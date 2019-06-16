<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
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

    <%! private int counter = 0; %>
    <div class="content">
        <span class="bigtitle">Hello World!</span>
        <div class="dottedline"></div>
        <%= LocalDate.now().toString() %>
        <br>
        <%= LocalDateTime.now().toString()%>

        <p>Next 10 days</p>
        <%

            final LocalDate today = LocalDate.now();

            for (int i = 0; i < 10; i++) {
                out.println(today.plusDays(i).toString());
                out.println("<br>");

            }


        %>

        <br>
        <p> visit counter</p>
        <%=this.counter++%>

        <p>${name}</p>
    </div>
    <div id="footer">

        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>
