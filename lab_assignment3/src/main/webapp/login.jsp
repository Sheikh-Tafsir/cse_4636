<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/25/2023
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div>
        <h1>Enter your credentials</h1>
        <form action="Login" method="post">
          <p>Username: </p>
          <input type="text" name="username"><br>
          <p>Password: </p>
          <input type="password" name="password"><br>
          <input type="submit" value="login" class="button">
        </form>
    </div>

</body>
</html>
