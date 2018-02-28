<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mes Commandes</title>
    </head>
    <body>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <hr />
        <h1>hellloàow</h1>
        <c:forEach items="${com}" var="c" >
            <h1>${c.getIDCompteCommande}, ${c.getIDCommande()}, ${c.getIDStatutCommande()}, ${c.getMontantCommande}</h1>
        </c:forEach>
    </body>
</html>


