<%@ page import="pl.sda.kubik.servlet.domain.User" %>
<%@ page import="pl.sda.kubik.servlet.domain.UsersRole" %><%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-03-30
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>webapp</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>

</head>
<body>
<div id="header">


    <div class="menu">

        <div class="option"><a class="menulink" href=${pageContext.request.contextPath}/home>Strona główna</a></div>
        <div class="option"><a class="menulink" href="${pageContext.request.contextPath}/homepage">Produkty</a></div>


        <%
            final Object loggedUser = session.getAttribute("loggedUser");
            if (loggedUser != null) {
                final User user = (User) loggedUser;
                if (user.getRoles().contains(UsersRole.ADMIN)) {

        %>
        <div class="option"><a class="menulink" href="${pageContext.request.contextPath}/addProduct">Dodaj produkt</a>
        </div>

        <%
                }
            }%>
        <div class="option"><a class="menulink" href="${pageContext.request.contextPath}/addToCart">Koszyk</a></div>
        <a class="menulink" href="${pageContext.request.contextPath}/orders">
            <div class="option">Historia zamówień</div>
        </a>


        <div style="clear:both;"></div>
        <%--    <form action="${pageContext.request.contextPath}/homepage" method="get">--%>
        <%--        <p>--%>
        <%--            Category<input type="text" name="category"/>--%>
        <%--        </p>--%>


        <%--        <p>--%>
        <%--            Submit <input type="submit" name="submit" value="submit"/>--%>
        <%--        </p>--%>
        <%--    </form>--%>

        <%--    <form action="${pageContext.request.contextPath}/homepage" method="get">--%>
        <%--        <p>Category</p>--%>
        <%--        <label>--%>
        <%--            <select name="category">--%>
        <%--                <option>Druid</option>--%>
        <%--                <option>Hunter</option>--%>
        <%--                <option>Mage</option>--%>
        <%--                <option>Paladin</option>--%>
        <%--                <option>Priest</option>--%>
        <%--                <option>Rouge</option>--%>
        <%--                <option>Shaman</option>--%>
        <%--                <option>Warrior</option>--%>
        <%--                <option>Dead Knight</option>--%>
        <%--            </select>--%>
        <%--        </label>--%>

        <%--        <p>--%>
        <%--            <input type="submit" name="submit" value="submit"/>--%>
        <%--        </p>--%>
        <%--    </form>--%>

    </div>

    <div class="logo">
        <%


            if (loggedUser != null) {
                final User user = (User) loggedUser;
                out.print("Witaj " + user.getLogin() + " :)");
        %>
    </div>
    <div class="topbar">
        <div class="square"><img src="\img\logo.png"></div>
        <div style="float: left">
            <jsp:include page="logOut.jsp"/>
        </div>
        <div style="clear: both"></div>
    </div>

    <%

    } else {
    %>
    <div class="logo">Witaj nieznajomy.</div>
    <div class="topbar">
        <div class="square">
            <jsp:include page="logIn.jsp"/>
        </div>
        <div class="square">
            <jsp:include page="register.jsp"/>
        </div>
        <div style="clear: both;"></div>
    </div>
    <%

        }


    %>


</div>
</body>
</html>
