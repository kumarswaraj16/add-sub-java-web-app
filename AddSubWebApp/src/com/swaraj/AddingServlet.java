package com.swaraj;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddingServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In AddingServlet Service Method!");
		
		int val1 = ((Integer) req.getAttribute("operand1")).intValue();
		int val2 = ((Integer) req.getAttribute("operand2")).intValue();
		
		int result = val1+val2;
		req.setAttribute("operation", "Addition");
		req.setAttribute("result", result);
		
		RequestDispatcher rd = req.getRequestDispatcher("/resp");
		rd.forward(req, res);
	}

}
