<%@ page import="java.time.LocalDate" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 2019-03-30
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>

<body>

<div id="footer">

    <%--    <div style="width: 100%;margin-left: auto;margin-right: auto;">--%>
    <%--        <div class="flag">--%>

    <%--            <a href="${pageContext.request.contextPath}/locale?locale=pl"><img src="/img/pl.png"></a>--%>
    <%--        </div>--%>
    <%--        <div class="flag">--%>
    <%--            <a href="${pageContext.request.contextPath}/locale?locale=us"><img src="/img/us.png"></a>--%>

    <%--        </div>--%>
    <%--        <div class="flag">--%>
    <%--            <a href="${pageContext.request.contextPath}/locale?locale=ue"><img src="/img/ue.png"></a>--%>

    <%--        </div>--%>
    <%--        <div style="clear: both"></div>--%>
    <%--    </div>--%>
    <div style="width: 100%;margin-left: auto;margin-right: auto;">
        <div class="flag">

            <form action="${pageContext.request.contextPath}/locale" method="post">
                <input type="hidden" value="pl" name="locale">


                <button type="submit"><img src="/img/pl.png"></button>
            </form>

        </div>
        <div class="flag">
            <form action="${pageContext.request.contextPath}/locale" method="post">
                <input type="hidden" value="us" name="locale">
                <button type="submit"><img src="/img/us.png"></button>
            </form>
        </div>
        <div class="flag">
            <form action="${pageContext.request.contextPath}/locale" method="post">
                <input type="hidden" value="ue" name="locale">
                <button type="submit"><img src="/img/ue.png"></button>
            </form>
        </div>
        <div style="clear: both"></div>
    </div>


    <p>Created by Tomek <%= LocalDate.now().toString()%> &copy;
    </p>
    <% String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
    %>
    <%--    <p>Twoje IP!</p>--%>
    <%--    <%--%>
    <%--        out.print(request.getRemoteAddr());--%>

    <%--    %><br>--%>
    <%--    <%--%>
    <%--        out.print(request.getRemoteHost());--%>

    <%--    %><br>--%>


    <%--    <h3> Client Side IP Address </h3><br>--%>
    <%--    <%out.print("Client IP Address :: " + request.getRemoteAddr()); %><br>--%>
    <%--    <%out.print("Client Name Host :: " + request.getRemoteHost());%><br>--%>

</div>
</body>