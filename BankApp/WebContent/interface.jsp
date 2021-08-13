<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
	.container{
		margin: 25px auto;
		width: 400px;
		border-radius: 25px;
		border: 2px solid black;
		padding: 40px; 
		font-size: 20px;
		font-weight: bold;
	}
	input{
		height: 30px;
		width: 200px;
		border-radius: 10px;
		margin: 0 auto;
		padding: 10px;
		
	}
	input[name=submit]{
		width: 300px;
		height: 40px;
		background-color: cornflowerblue;
		font-size: 15px;
		font-weight: bold;
		display: block;
		margin: 15px auto;
		
	}
	input[name=submit]:hover{
		background-color: royalblue;
	}
</style>
</head>
<body>
	<div class="container">
		<h1><%out.println("Welcome "+session.getAttribute("name")+"!");%></h1>
		<h1><%out.println("Account Balance: $"+session.getAttribute("balance")); %></h1>
		
		<form action="addMoney.html">
			<input type="submit" name="submit" value="Add Money" />
		</form>
		
		<form action="transferMoney.html">
			<input type="submit" name="submit" value="Transfer Money" />
		</form>
		
		<form action="changePwd.html">
			<input type="submit" name="submit" value="Change Password" />
		</form>
		
		<form action="Logout">
			<input type="submit" name="submit" value="Logout" />
		</form>
	</div>
</body>
</html>