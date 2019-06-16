<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-06
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,900&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'>
</head>
<body>
<div id="container">


    <div id="header">

        <jsp:include page="header.jsp"/>
    </div>
    <div class="content">

        <form action="${pageContext.request.contextPath}/addProduct" method="post">


            <p>Product name
                <input type="text" name="name"/>
            </p>

            <p>description
                <input type="text" name="description"/>
            </p>
            <p>price
                <input type="text" name="price"/>
            </p>
            <p>image
                <input type="text" name="image"/>
            </p>
            <p>Category</p>

            <label>
                <input type="checkbox" name="category" value="Druid"> Druid
            </label>
            <label>
                <input type="checkbox" name="category" value="Hunter"> Hunter
            </label>
            <label>
                <input type="checkbox" name="category" value="Mage"> Mage
            </label>
            <label>
                <input type="checkbox" name="category" value="Paladin"> Paladin
            </label>
            <label>
                <input type="checkbox" name="category" value="Priest"> Priest
            </label>
            <label>
                <input type="checkbox" name="category" value="Rouge"> Rouge
            </label>
            <label>
                <input type="checkbox" name="category" value="Shaman"> Shaman
            </label>
            <label>
                <input type="checkbox" name="category" value="Warrior"> Warrior
            </label>
            <label>
                <input type="checkbox" name="category" value="Dead Knight"> Dead Knight
            </label>


            <p>
                <input type="submit" name="submit" value="Submit"/>
            </p>


        </form>
    </div>
    <div id="footer">

        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>
