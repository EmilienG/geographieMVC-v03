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
            <table  id="tableau">
                <tr>  
                <thead>
                <th scope="col">
                    Colonne1
                </th>
                <th scope="col">
                    Colonne2
                </th>
                <th scope="col">
                    Colonne3
                </th>
                </thead>
                <tfoot>
                    <tr>
                        <td colspan="5">Classement Blogspot par Wikio - Mai 2010</td>
                    </tr>
                </tfoot>
                <tbody>
                    </tr>
                    <c:forEach  var="unLivre" items="${maListeLivres}">
                        <tr> 
                            <td>  <span class="isbn"><i>ISBN:${unLivre.getISBNlivre()}</i></span>
                                <br>
                                <a href="#"><b>${unLivre.getTitreLivre()}</b></a>
                                <br>
                                ${unLivre.getSousTitreLivre()}
                                <br>
                                <span class="parution">(Parution : ${unLivre.getDateParutionLivre()})</span>
                                <hr>    
                                <img src="${path}${unLivre.getCouvertureLivre()}" alt="${unLivre.getCouvertureLivre()}"  width="15%"/>
                                <br>
                                <span class="resume">
                                    <i>${unLivre.getResumeCourt()}(...)</i>
                                    <br>
                                    <a href="#">[+info]</a>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <c:if test="${unLivre.getDisponibilite()}">
                                    <span class="dispo"><b></b>Disponible</b></span>
                                        </c:if> <c:if test="${!unLivre.getDisponibilite()}">
                                    <span class="rupture"><b>Rupture</b></span>
                                </c:if>
                                <br>
                                Prix : <b>${unLivre.getPrixHTLivre()} €</b>
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </center>
</body>
</html>


