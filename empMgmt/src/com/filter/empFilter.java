package com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import com.util.DbUtil;
import com.util.commonUtils;

/**
 * Servlet Filter implementation class empFilter
 */
@WebFilter("/empFilter")
//@WebFilter(filterName = "empFilter", urlPatterns = { "/*" })
public class empFilter implements Filter {

    /**
     * Default constructor. 
     */
    public empFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	 // Check the target of the request is a servlet?
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        // 
        // Servlet Url-pattern: /spath/*
        // 
        // => /spath
        String servletPath = request.getServletPath();
        // => /abc/mnp
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            // => /spath/*
            urlPattern = servletPath + "/*";
        }
 
        // Key: servletName.
        // Value: ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();
 
        // Collection of all servlet in your Webapp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 HttpServletRequest req = (HttpServletRequest) request;
		 
		  if (this.needJDBC(req)) {
			  
	            System.out.println("Open Connection for: " + req.getServletPath());
	 
	            Connection conn = null;
	            try {
	                // Create a Connection.
	                conn = DbUtil.createConnection();
	                // Set outo commit to false.
	                conn.setAutoCommit(false);
	 
	                // Store Connection object in attribute of request.
	                commonUtils.storeMyConnection(request, conn);
	                // Allow request to go forward
	                // (Go to the next filter or target)
	                chain.doFilter(request, response);
	 
	                // Invoke the commit() method to complete the transaction with the DB.
	                conn.commit();
	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new ServletException();
	            } finally {
	            	DbUtil.closeConnection(conn);
	            }
	        }
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
