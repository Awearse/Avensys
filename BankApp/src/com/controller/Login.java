package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		Model m = new Model();
		m.setEmail(email);
		m.setPwd(pwd);
		
		
		int x = m.login();
		if(x==1) {
			String name = m.getName();
			String balance = m.getBalance();
			
			HttpSession session = req.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("balance", balance);
			
			resp.sendRedirect("/BankApp/interface.jsp");
		}else {
			resp.sendRedirect("/BankApp/accNotReg.html");
		}
	}

}
