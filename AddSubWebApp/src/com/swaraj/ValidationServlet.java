package com.swaraj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Service Method!");
		
		try {
			int val1 = Integer.parseInt(req.getParameter("op1"));
			int val2 = Integer.parseInt(req.getParameter("op2"));
			req.setAttribute("operand1", val1);
			req.setAttribute("operand2", val2);
		}catch(Exception e) {
			e.printStackTrace();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("Operand 1 and Operand 2 should be numbers <br/><br/><br/>");
			RequestDispatcher rd = req.getRequestDispatcher("/Home.html");
			rd.include(req, res);
			return;
		}
		String action = (String) req.getParameter("action");
		RequestDispatcher rd=null;
		if(action.equals("Add")) {
			rd = req.getRequestDispatcher("/add");
		}else {
			rd = req.getRequestDispatcher("/sub");
		}
		rd.forward(req, res);
	}

}
