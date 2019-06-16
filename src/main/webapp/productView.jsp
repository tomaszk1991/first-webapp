<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-06
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Created</title>
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


        <div class="cards">
            <h1>${product.getName()}<br/></h1>
            ${product.getDescription()}<br/>
            ${product.getCategories()}<br/>
            ${product.getPrice()}<br/>
            <img src="${product.getImage()}"><br/>


            <br/><br/>
            <span class="bigtitle">REKLAMA</span><br>
            <p>${lastView.getName()}<br>
                ${lastView.getDescription()}<br>
                ${lastView.getCategories()}<br>
                ${lastView.getPrice()}<br>
                <img src="${lastView.getImage()}"></p>

        </div>

    </div>

    <div id="footer">

        <jsp:include page="footer.jsp"/>
    </div>


</div>
</body>
</html>
