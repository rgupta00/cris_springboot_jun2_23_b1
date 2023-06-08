package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	@Override
	public void init() throws ServletException {
		System.out.println("it is init method");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("it is a service method ");
		
		PrintWriter out=response.getWriter();
		out.print("hello to servlet");
	}


    
	@Override
	public void destroy() {
		System.out.println("it is destroy method");
	}


	

}
