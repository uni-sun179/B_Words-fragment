package tool;

public class Escape {
	public static String htmlEscape(String text) {
	    String replacedText =text.replace("&", "&amp;")
				                .replace("<", "&lt;")
				                .replace(">", "&gt;")
				                .replace("\"", "&quot;")
				                .replace("'", "&#39;");
	    
	    return replacedText;
	}
}
