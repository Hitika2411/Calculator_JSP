<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<style>
img {
  height: 20%;
  width: 20%;
}
body {
  text-align: center;
  background: linear-gradient(to right, #FFDB58, #900C3F);
}
</style>
</head>
<body>
<img src="images/4AIB.gif" alt="Loading..." id="main-image">

<form action="MyWebServlet" method="get">
  <h1>Have Fun Calculating!!!</h1>
  <input name="num1" placeholder="Enter first number">
  <input name="num2" placeholder="Enter second number">
  <button name="btn1" value="+">+</button>
  <button name="btn1" value="-">-</button>
  <button name="btn1" value="*">*</button>
  <button name="btn1" value="/">/</button>
</form>

<h1> Ans=<%=request.getParameter("ans") %></h1>
 



<% if (request.getParameter("ans") != null) { %>
  <img src="images/09fd35b35da1d556f7716228a16f5b43_w200.gif" alt="Result Image">
<% } %>
<h3><%=request.getParameter("joke") %></h3>
</body>
</html>
