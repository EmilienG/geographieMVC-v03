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
                        <td><i>ISBN:${unLivre.getISBNlivre()}</i>
                            <br>
                            <a href="#"><b>${unLivre.getTitreLivre()}</b></a>
                            <br>
                            ${unLivre.getSousTitreLivre()}
                            <br>
                            ( ${unLivre.getDateParutionLivre()})
                        </td>
                        <td>
                            <i>${unLivre.getResumeCourt()}(...)</i>
                            <br>
                            <a href="#">[+info]</a>
                        </td>
                        <td>
                            <img src="${path}${unLivre.getCouvertureLivre()}" alt="${unLivre.getCouvertureLivre()}"  width="25%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${unLivre.getDisponibilite()}">
                                Disponible
                            </c:if> <c:if test="${!unLivre.getDisponibilite()}">
                                Rupture
                            </c:if>
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


