package com.log.streamer.demo.ui;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserInterface {

	@WebServlet(urlPatterns = "/country/*", loadOnStartup = 1)
	public class HelloCountryServlet extends HttpServlet   {
	    private static final long serialVersionUID = 1L;
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
	         doGet(request,response);
	    }
	        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	             response.setContentType("text/html");
	             PrintWriter out = response.getWriter();
	         out.println("<h3>Hello India!</h3>");  
	    }
	}
	
	
}
