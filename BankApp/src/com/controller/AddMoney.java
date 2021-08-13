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
 * Servlet implementation class AddMoney
 */
@WebServlet("/AddMoney")
public class AddMoney extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String amt = req.getParameter("amt");
		
			Model m = new Model();
			m.setAmt(amt);
			
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			m.setEmail(email);
			
			int x = m.addMoney();
			if(x==0) {
				resp.sendRedirect("/BankApp/topUpFail.html");
			}else {
				session.setAttribute("balance", m.getBalance());	
				resp.sendRedirect("/BankApp/topUpSuccess.html");
			}
	}

}
