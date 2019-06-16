<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-07
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>

<form action="${pageContext.request.contextPath}/logOut" method="post">
    <p>
        <input type="submit" name="submit" value="LogOut"/>
    </p>

</form>
</body>
</html>
