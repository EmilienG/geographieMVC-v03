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
                    Fiche de l'ouvrage
                </th>
                <th scope="col">
                    Details
                </th>
                <th scope="col">
                    Panier
                </th>
                </thead>
                <tfoot>
                    <tr>
                        <td colspan="5">Catalogue Librairie Fusion</td>
                    </tr>
                </tfoot>
                <tbody>
                    </tr>
                    <c:forEach  var="unLivre" items="${maListeLivres}">
                        <tr> 
                            <td> 
                                <span class="isbn"><i>ISBN:${unLivre.getISBNlivre()}</i></span>
                                <span class="titre" >
                                    <a href="#"><b>${unLivre.getTitreLivre()}</b></a>
                                            ${unLivre.getSousTitreLivre()}
                                </span>
                                <span class="titre" >
                                    <span class="parution">(Parution : ${unLivre.getDateParutionLivre()})</span>
                                </span>
                                <hr>    
                                <img src="${path}${unLivre.getCouvertureLivre()}" alt="${unLivre.getCouvertureLivre()}"  width="15%"/>
                                <span class="resume">
                                    <i>${unLivre.getResumeCourt()}(...)</i>
                                    <a href="#">[+info]</a>
                                </span>
                            </td>

                            <td>
                                <c:if test="${unLivre.getDisponibilite()}">
                                    <span class="dispo"><b></b>Disponible</b></span>
                                        </c:if> <c:if test="${!unLivre.getDisponibilite()}">
                                    <span class="rupture"><b>Rupture</b></span>
                                </c:if>
                                <br>
                                Prix : <b>${unLivre.getPrixHTLivre()} €</b>
                            </td>
                            <td>
                                Ajouter au panier
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </center>
</body>
</html>


