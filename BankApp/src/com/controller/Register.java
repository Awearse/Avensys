package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Model;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String cpwd = req.getParameter("cpwd");
		
		if(pwd.equals(cpwd)) {
			Model m = new Model();
			m.setName(name);
			m.setEmail(email);
			m.setPwd(pwd);
			
			int x = m.register();
			if(x==0) {
				resp.sendRedirect("/BankApp/failReg.html");
			}else {
				resp.sendRedirect("/BankApp/successReg.html");
			}
		}else {
			//password and confirm password does not match
			
		}
	}

}
