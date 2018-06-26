package org.com.cay.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cay on 2018/6/8.
 */
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;

		//支持所有的origin跨域
		HttpServletRequest req = (HttpServletRequest) request;
		String origin = req.getHeader("Origin");
		if(!StringUtils.isEmpty(origin)){
			res.addHeader("Access-Control-Allow-Origin", origin);
		}

		//允许http://localhost:8081访问
		//res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
		res.addHeader("Access-Control-Allow-Methods", "GET");
		//res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		res.addHeader("Access-Control-Max-Age", "30");

		//允许所有域的所有方法来请求
//		res.addHeader("Access-Control-Allow-Origin", "*");
//		res.addHeader("Access-Control-Allow-Methods", "*");

		//带cookie的跨域
		//1、Origin必须是全匹配，不能是通配符*
		//2、必须添加Access-Control-Allow-Credentials为true
		//res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
		res.addHeader("Access-Control-Allow-Credentials", "true");

		//带自定义header的请求
//		res.addHeader("Access-Control-Allow-Headers","Content-Type,x-header1,x-header2");

		//支持所有的header
		String header = req.getHeader("Access-Control-Request-Headers");
		if(!StringUtils.isEmpty(header)){
			res.addHeader("Access-Control-Allow-Headers",header);

		}

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}
}
