<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Hello recherche</h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url04"/>    
            <c:import url="${url04}"/>
        </nav>
        <hr/>
                <c:forEach var="maRecherche" items="${mesResultats}">     
                    ${maRecherche}
                </c:forEach>
              
     
    </body>
</html>
