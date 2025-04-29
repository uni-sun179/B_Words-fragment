package tool;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= { "*.action" })
public class FrontController extends HttpServlet {
	public void doPost(
			HttpServletRequest request,HttpServletResponse response
	) throws IOException,ServletException{
		
		try {
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace("/",".");
			Action action =(Action) Class.forName(name)
					.getDeclaredConstructor().newInstance();
			String url = action.execute(request, response);
			request.getRequestDispatcher(url)
							.forward(request, response);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(
			HttpServletRequest request,HttpServletResponse response
	) throws IOException,ServletException{
		doPost(request,response);
	}
}
