package checker;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Post;
import dao.PostDAO;
import tool.Action;
import tool.Escape;

//NGワードの判定を行うクラス
public class CheckAction extends Action {

	private static final String path = "/WEB-INF/ng_words.txt";
	private boolean isContains;
	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		ServletContext context = request.getServletContext();
		PostDAO dao = new PostDAO();
		//NGワードリストのパスを取得
		String realPath = context.getRealPath(path);
		String postText = request.getParameter("postText");
		//null対策
		if(postText == null || postText.isEmpty()) postText = "nullが入力されました";
		//htmlエスケープ（APIがあれば使用したい）
				postText = Escape.htmlEscape(postText);
		//NGワードのチェック
		try(Stream<String> lines = Files.lines(Paths.get(realPath))){
			isContains = lines.anyMatch(postText::contains);
		}	
		//insert文の可否に応じてmessageを取得
		String message = dao.Insert(postText, isContains);
		request.setAttribute("message", message);
		
		//投稿一覧をリクエストにセット
		List<Post> list = dao.select();
		request.setAttribute("list", list);
		return "checked.jsp";
	}

}
