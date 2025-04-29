package tool;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns= {"/*"})
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response, 
			FilterChain chain
	)throws IOException, ServletException {
		// TODO 自動生成されたメソッド・スタブ
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig config) {}
	public void destroy() {}
}
