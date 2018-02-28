

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
      <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>catalogue</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
<nav>
           <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
            
        </nav>
      <hr/>
        <table>
            <tr>
                <c:forEach var="monLivre" items="${mesLivres}">
                    <td> ${monLivre.getTitreLivre()}, ${monLivre.getSousTitreLivre()} </td>
                </c:forEach>
            </tr>
        </table>
   </body>
</html>
