package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	ResultSet res2;
	
	private String email;
	private String pwd;
	private String name;
	private String newpwd;
	private String balance;
	private String amt;
	private String recipientBalance;
	private String receipientName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String un) {
		this.email = un;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getRecipientBalance() {
		return recipientBalance;
	}
	public void setRecipientBalance(String recipientBalance) {
		this.recipientBalance = recipientBalance;
	}
	public String getReceipientName() {
		return receipientName;
	}
	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}
	
	public Model() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApp","root","root");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int register() {
		try {
			String sql = "Insert into users values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2,pwd);
			pstmt.setString(3,name);
			pstmt.setInt(4, 0);
			
			int x = pstmt.executeUpdate();
			return x;
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int login() {
		try {
			String sql = "select * from users where email=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			
			res = pstmt.executeQuery();
			if(res.next()==true) {
				name=res.getString("name");
				balance=res.getString("balance");
				return 1;
			}else {
				return 0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int changePwd() {
		try {
			String sql1 = "Select * from users where email=? and password=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);
			
			res = pstmt.executeQuery();
			if(res.next()==true) { //There is valid email and pwd
				String sql2 ="update users set password=? where email=?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, newpwd);
				pstmt.setString(2, email);
				
				int x = pstmt.executeUpdate();
				return x;
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int addMoney() {
		try {
			String sql1 = "Select * from users where email=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
			if(res.next()==true) { //There is valid email
				String sql2 ="update users set balance=? where email=?";
				pstmt = con.prepareStatement(sql2);
				balance = res.getString("balance"); //get balance from res
				pstmt.setInt(1, Integer.parseInt(balance)+Integer.parseInt(amt));
				pstmt.setString(2, email);
				
				int x = pstmt.executeUpdate();
				updateBalance(); //to update the session values and hence interface.jsp
				
				return x;
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int transferMoney(){
		try {
			String sql1 = "Select * from users where email=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, email);
			res = pstmt.executeQuery();
			
			if(res.next()==true) { //There is valid email
				String sql2 ="update users set balance=? where email=?";
				pstmt = con.prepareStatement(sql2);
				balance = res.getString("balance");
				pstmt.setInt(1, Integer.parseInt(balance)-Integer.parseInt(amt));
				pstmt.setString(2, email);
				pstmt.executeUpdate();
				
				//Get Receipient Record
				String sql3 = "Select * from users where name=?";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, receipientName);
				res2 = pstmt.executeQuery();
				
				if(res2.next()==true){
					String sql4 = "update users set balance=? where name=?";
					pstmt = con.prepareStatement(sql4);
					recipientBalance = res2.getString("balance");
					pstmt.setInt(1, Integer.parseInt(recipientBalance)+Integer.parseInt(amt));
					pstmt.setString(2, receipientName);
					int x = pstmt.executeUpdate();
					updateBalance();
					return x;
				}else {
					return 0;
				}
			}else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void updateBalance() throws SQLException{
		String sql1 = "Select * from users where email=?";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1, email);
		res2 = pstmt.executeQuery();
		if(res2.next()==true) {
			balance = res2.getString("balance");
		}
	}
	

	
}
