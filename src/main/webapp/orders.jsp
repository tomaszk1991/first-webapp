<%@ page import="pl.sda.kubik.servlet.domain.Order" %>
<%@ page import="pl.sda.kubik.servlet.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-13
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
            final List<Order> orders = (List<Order>) request.getAttribute("orders");

            if (orders != null) {

                out.println(orders.get(0).getUser().getLogin());%>
        <div class="dottedline"></div>

        <%
            for (final Order order : orders) {

                for (final Map.Entry<Product, Integer> entry : order.getCart().get().entrySet()) {

        %>

        <br/>
        <%

                out.println(entry.getKey().getName() + " " + entry.getValue() + " sztuk");

            }
        %><p>
        <%
            out.println("cena łączna " + order.getTotalPrice() + " " + order.getLocale());
        %></p>
        <div class="dottedline"></div>

        <%


            }


        %>


        <%
            }

        %>

    </div>

    <div id="footer">
        <jsp:include page="footer.jsp"/>
    </div>

</div>

</body>
</html>
