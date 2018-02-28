

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <hr />
        <div style="overflow-x:auto;">
            <table>
                <c:forEach  var="unLivre" items="${maListeLivres}">
                    <tr>  
                        <td>
                            <img src="img\${unLivre.getCouvertureLivre()}" alt=""> 
                            ${unLivre.getCouvertureLivre()}
                        </td>
                        <td>
                            ${unLivre.getTitreLivre()}
                            <br>
                            ${unLivre.getSousTitreLivre()}
                        </td>
                    </tr> 
                    <tr> 
                        <td>
                            ${unLivre.getDateParutionLivre()}
                        </td> 
                        <td>
                            ${unLivre.getPrixHTLivre()}
                        </td> 
                        <td>
                            ${unLivre.getQuantiteStockLivre()}
                        </td> 
                    </tr>
                </c:forEach> 
            </table>
        </div>
    </body>
</html>


