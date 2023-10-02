<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/27/2023
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
<h1>Login Page</h1>
    <!--we can use the parameters passed like below. two ways.-->
   <form action="/mvcproject/api/login" method="POST">
       <span>Email : </span>
       <input type="text" name="name"/>
       <span>Password :</span>
       <input type="password" name="password" value={model.age}/>
       <input type="submit" value="submit">
   </form>
</body>
</html>
