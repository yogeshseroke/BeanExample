<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Staff Registration Form</h1>
<form action="beanSer" method="post">

<input type="text" name="txtsid" placeholder="Enter staff ID" />
<br><br>
<input type="text" name="txtpass" placeholder="Enter password" />
<br><br>
<input type="text" name="txtfname" placeholder="Enter fullname" />
<br><br>
<input type="text" name="txtrole" placeholder="Enter role" />
<br><br>
<input type="submit" name="btnsubmit" value="Click" />
</form>

<a href="beanlogin.jsp">Login Here</a>
</body>
</body>
</html>