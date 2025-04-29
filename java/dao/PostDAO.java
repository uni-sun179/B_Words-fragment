package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Post;

public class PostDAO extends DAO {
	public String Insert(String post_text,boolean contains)
		throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"insert into post(post_text,isContains) values(?,?)");
		st.setString(1, post_text);
		st.setBoolean(2, contains);
		int line = st.executeUpdate();
		String message;
		if(line != 1) {
			message = "投稿に失敗しました。"
					+ "時間を置いて再度お試しください。";
		}
		else {
			message = "投稿に成功しました。";
		}
		
		st.close();
		con.close();
		return message;
	}
	
	//データベースから投稿一覧を取得
	public List<Post> select()  throws Exception{
		Connection con = getConnection();
		PreparedStatement st= con.prepareStatement(
				"select * from post order by id desc limit 15");
		List<Post> list = new ArrayList<Post>();
		ResultSet rs =st.executeQuery();
		while(rs.next()) {
			Post post = new Post();
			post.setId(rs.getInt("id"));
			post.setPostText(rs.getString("post_text"));
			post.setIsContains(rs.getBoolean("isContains"));
			list.add(post);
		}
		
		st.close();
		con.close();
		
		return list;
	}
}
