<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-04-13
  Time: 20:46
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

        <form action="${pageContext.request.contextPath}/buyData" method="post">
            <%
                final Object loggedUser = session.getAttribute("loggedUser");

                if (loggedUser == null) {


            %>

            <p>Login <input type="text" name="login"/></p>


            <p>Hasło <input type="password" name="password"/></p>


            <p>Email<input type="text" name="email"/></p>


            <%


                }
            %>


            <p>Adres <input type="text" name="adress"/></p>


            <p>Numer budynku <input type="text" name="buildingNumber"/></p>


            <p>Numer mieszkania <input type="text" name="homeNumber"/></p>
            <p>Miasto <input type="text" name="city"/></p>
            <p><input type="submit" name="submit" value="Kup"/></p>


        </form>

    </div>

    <div id="footer">
        <jsp:include page="footer.jsp"/>
    </div>

</div>

</body>
</html>
