<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-06
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,900&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">


    <%--    <p>Login--%>
    <%--        <input type="text" name="login"/> ${loginError}--%>
    <%--    </p>--%>

    <%--    <p>Password--%>
    <%--        <input type="password" name="password"/>--%>
    <%--    </p>--%>
    <%--    <p>Email--%>
    <%--        <input type="text" name="email"/> ${emailError}--%>
    <%--    </p>--%>
    <%--    <p>--%>
    <%--        <input type="submit" name="submit" value="submit"/>${blank}--%>
    <%--    </p>--%>

    <h2>Rejestracja</h2>

    <table style="color: white">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"/> ${loginError}</td>
        </tr>
        <tr>
            <td>Hasło</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/> ${emailError}</td>
        </tr>
    </table>
    <p>
        <input type="submit" name="submit" value="Rejestracja"/>${blank}
    </p>

</form>


<h1>${userCreated}</h1>


</body>
</html>
