<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-06
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>id=${id} not found</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,900&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'>
</head>
<body>
<div id="container">

    <div id="header">
        <jsp:include page="header.jsp"/>
    </div>

    <div class="content">
        <span class="bigtitle">Product with id=${id} not found.</span>
    </div>
    <div id="footer">
        <jsp:include page="footer.jsp"/>
    </div>

</div>
</body>
</html>
