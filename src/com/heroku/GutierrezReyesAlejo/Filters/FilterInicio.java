package com.heroku.GutierrezReyesAlejo.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter(description = "Redirige del index al formulario", urlPatterns = { "/index.jsp" })
public class FilterInicio implements Filter {

    public FilterInicio() {}


	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpServletResponse httpResponse = (HttpServletResponse) response;
		//httpResponse.sendRedirect("/WEB-INF/jsp/formularioCifrado.jsp");
		//chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
