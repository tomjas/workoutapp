package com.workout.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workout.model.User;

@WebFilter(urlPatterns = "/pages/protected/admin/*")
public class AdminFilter implements Filter {

	public AdminFilter() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user");	

		if (user == null || !user.isAdmin()) {
			//TODO Zrobić access denied zamiast przekierowania na login!
			resp.sendRedirect(req.getContextPath() + "/pages/public/login.jsf");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
