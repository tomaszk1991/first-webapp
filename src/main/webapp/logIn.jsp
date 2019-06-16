<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-07
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>

<form action="${pageContext.request.contextPath}/logIn" method="post">
    <h2>Zaloguj się</h2>
    <%--    <p>Login--%>
    <%--        <input type="text" name="login"/>--%>
    <%--    </p>--%>

    <%--    <p>Password--%>
    <%--        <input type="password" name="password"/>--%>
    <%--    </p>--%>

    <%--    <p>--%>
    <%--        <input type="submit" name="submit" value="Zaloguj"/>--%>
    <%--    </p>--%>
    <table style="color: white;">
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
    <p><input type="submit" name="submit" value="Zaloguj"/></p>

</form>
<h3>${logInError}</h3>


</body>
</html>
