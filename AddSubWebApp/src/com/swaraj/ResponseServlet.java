package com.swaraj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ResponseServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Response Service Method!");
		int result = ((Integer) req.getAttribute("result")).intValue();
		String operation = (String) req.getAttribute("operation");
		RequestDispatcher rd = req.getRequestDispatcher("/Home.html");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println(operation + "Result is : <b>" + result + "</b><br/>");
		rd.include(req, res);
	}

}
