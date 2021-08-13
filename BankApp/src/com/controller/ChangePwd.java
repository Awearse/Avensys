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
 * Servlet implementation class ChangePwd
 */
@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd = req.getParameter("pwd");
		String newpwd = req.getParameter("newpwd");
		String cnewpwd = req.getParameter("cnewpwd");
		
		if(newpwd.equals(cnewpwd)) {
			Model m = new Model();
			m.setPwd(pwd);
			m.setNewpwd(newpwd);
			
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			m.setEmail(email);
			int x = m.changePwd();
			if(x==0) {
				resp.sendRedirect("/MyApp/pwdNotChanged.html");
			}else {
				resp.sendRedirect("/MyApp/pwdChanged.html");
			}
		}else {
			//newpwd and cnewpwd is not the same
		}
	}

}
