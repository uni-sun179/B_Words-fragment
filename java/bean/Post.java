package bean;

import java.io.Serializable;

public class Post implements Serializable {
	private int id;
	private String postText;
	private boolean isContains;
	
	public int getId() {
		return id;
	}
	
	public String getPostText() {
		return postText;
	}
	
	public boolean getIsContains() {
		return isContains;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPostText(String postText) {
		this.postText = postText;
 	}
	
	public void setIsContains(boolean isContains) {
		this.isContains = isContains;
	}
}
