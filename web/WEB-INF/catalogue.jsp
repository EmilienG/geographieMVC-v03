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
    <center>
        <h1>
            <span>Catalogue</span>
        </h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <hr />
        <div style="overflow-x:auto;">
            <table>
                <tr>
                    <td>
                        Titre1
                    </td>
                    <td>
                        Titre2
                    </td>
                    <td>
                        Titre3
                    </td>
                </tr>
                <c:forEach  var="unLivre" items="${maListeLivres}">
                    <tr> 
                        <td>
                            ${unLivre.getTitreLivre()}
                            <br>
                            ${unLivre.getSousTitreLivre()}
                            <br>
                            ( ${unLivre.getDateParutionLivre()})
                        </td>
                        <td>
                            <div style="toto">
                                <img src="${path}${unLivre.getCouvertureLivre()}" alt="${unLivre.getCouvertureLivre()}"  width="25%"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Qté : ${unLivre.getQuantiteStockLivre()}
                        </td>
                        <td>
                            Prix : ${unLivre.getPrixHTLivre()} €
                        </td>
                    </tr>
                </c:forEach> 
            </table>
        </div>
    </center>
</body>
</html>


