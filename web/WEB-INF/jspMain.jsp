<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP main</title>
    </head>
    <body>
        <h1>JSP main </h1>
        <jsp:include page="/ControllerMain?section=menu-main" flush="true"/>
        <hr>
        <jsp:include page="/ControllerMain?section=catalogue" flush="true"/>
    </body>
</html>
