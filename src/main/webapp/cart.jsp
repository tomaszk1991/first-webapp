<%@ page import="pl.sda.kubik.servlet.domain.Cart" %>
<%@ page import="pl.sda.kubik.servlet.domain.Product" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-13
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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


        <%
            double totalPrice = 0l;
            Long idChanger = 0l;

            final Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null) {
                for (final Map.Entry<Product, Integer> entry : cart.get().entrySet()) {
                    totalPrice = totalPrice + entry.getKey().getPrice() * entry.getValue();
                    idChanger = entry.getKey().getId();

        %>

        <div style="float: left; width: 260px;">
            <div class="bigtitle">
                <%
                    out.print(entry.getKey().getName());

                %></div>
            <p>Ilość:


            </p>
            <form action="${pageContext.request.contextPath}/addToCart" method="post">

                <input type="hidden" name="id" value="<%out.print(idChanger);%>"/>

                <input type="hidden" name="qt" value="-1">
                <input type="submit" name="submit" value="<-"/>
            </form>


            <%


                out.print(entry.getValue());


            %>


            </p>
            <form action="${pageContext.request.contextPath}/addToCart" method="post">

                <input type="hidden" name="id" value="<%out.print(idChanger);%>"/>

                <input type="hidden" name="qt" value="1">
                <input type="submit" name="submit" value="->"/>
            </form>
            <p>Cena: <%
                out.print(entry.getKey().getPrice() * entry.getValue());

            %>
            </p></div>
        <div style="float: left; border-right: 2px dotted #444444; border-left: 2px dotted #444444;">
            <img src="<%out.print(entry.getKey().getImage());%>">

        </div>
        <div style="float: left; padding: 5px; text-align: justify;"><%
            out.print(entry.getKey().getDescription());%></div>
        <div style="clear: both"></div>
        <div class="dottedline"></div>

        <%
            }

        %>
        <p>Cena łącznie: <%
            out.print(totalPrice);

        %></p>
        <form action="${pageContext.request.contextPath}/buyData" method="get">

            <input type="submit" name="submit" value="Kup">
        </form>
        <% } %>
    </div>

    <jsp:include page="footer.jsp"/>
    <div id="footer"></div>
</div>


</body>
</html>
