package com.school.sms.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class LoginFilter extends UsernamePasswordAuthenticationFilter {

	  private static final String DEFAULT_FILTER_PROCESSES_URL = "/j_spring_security_check";
	  private static final String POST = "POST";

	  public LoginFilter () {
	    super();
	    setUsernameParameter("username");
	    setPasswordParameter("password");
	  }

	  @Override
	  public Authentication attemptAuthentication(HttpServletRequest request,
	    HttpServletResponse response) throws AuthenticationException {
	    // You'll need to fill in the gaps here.  See the source of
	    // UsernamePasswordAuthenticationFilter for a working implementation
	    // you can leverage.
		  
		  return super.attemptAuthentication(request, response);
	  }

	  @Override
	  public void doFilter(ServletRequest req, ServletResponse res,
	    FilterChain chain) throws IOException, ServletException {
	    final HttpServletRequest request = (HttpServletRequest) req;
	    final HttpServletResponse response = (HttpServletResponse) res;
	    if(request.getMethod().equals(POST)) {
	      // If the incoming request is a POST, then we send it up
	      // to the AbstractAuthenticationProcessingFilter.
	    	request.getSession().setAttribute("userType",request.getParameter("userType"));
	      super.doFilter(request, response, chain);
	    } else {
	      // If it's a GET, we ignore this request and send it
	      // to the next filter in the chain.  In this case, that
	      // pretty much means the request will hit the /login
	      // controller which will process the request to show the
	      // login page.
	    	
	    	if(request.getRequestURL().toString().contains("sms/admin")){
	    		request.getSession().setAttribute("user_type", "Admin");
	    	}
	    	else if(request.getRequestURL().toString().contains("sms/user")){
	    		request.getSession().setAttribute("user_type","User");
	    	}
	      chain.doFilter(request, response);
	    }
	  }

	}