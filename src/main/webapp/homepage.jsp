<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-03-30
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>products</title>
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


        <c:forEach items="${products}" var="product">
            <div class="cards">
                <p>
                    <a href="/productView?id=${product.getId()}">${product.getName()}</a>
                </p>
                <p>${product.getDescription()}</p>
                <p>${product.getCategories()}</p>
                <p>${product.getPrice()}</p>
                <p><img src="${product.getImage()}"></p><br>

                <form action="${pageContext.request.contextPath}/addToCart" method="post">

                    <input type="hidden" name="id" value="${product.getId()}"/>

                    <label>
                        <input type="number" name="qt" min="1" max="10" value="1">
                    </label>
                    <input type="submit" name="submit" value="Do koszyka"/>
                </form>

            </div>
        </c:forEach>

        <div style="clear: both"></div>
    </div>

    <div id="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>
