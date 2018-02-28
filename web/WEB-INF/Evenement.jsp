<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evenement</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
 
        <h1>Evenement</h1>
          <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />//
        </nav>
        <hr />
         <ul class="menu">
   
                <c:forEach var="monEvenement" items="${mesEvenements}">
                <li> ${monEvenement.getNomEvenement()}, ${monEvenement.getDateDebutEvenement()} </li>
                </c:forEach>
        </ul>
                
    </body>
</html>
