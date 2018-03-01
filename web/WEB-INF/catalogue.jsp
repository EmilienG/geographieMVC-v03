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
                <thead>
                    <tr>
                        <td colspan="5">Mon Catalogue Fusion</td>
                    </tr>
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
                <tbody>
                    <c:forEach  var="unLivre" items="${maListeLivres}">
                        <tr> 
                            <td> 
                                <span class="isbn"><i>ISBN:${unLivre.ISBNlivre}</i></span>
                                <span class="titre" >
                                    <a href="#"><b>${unLivre.titreLivre}</b></a>
                                            ${unLivre.sousTitreLivre}
                                </span>
                                <span class="titre" >
                                    <span class="parution">(Parution : ${unLivre.dateParutionLivre})</span>
                                </span>
                                <hr>  
                                <span class="couverture" >
                                    <img src="${path}${unLivre.couvertureLivre}" alt="${unLivre.couvertureLivre}"  width="150"/>                                      
                                </span>
                                <span class="resume">
                                    <i>${unLivre.resumeCourt}(...)</i>
                                    <a href="#">[+info]</a>
                                </span>
                                <br>
                                <span class="motCle">Mots Clé : ${unLivre.descriptionMotClef}</span>
                            </td>
                            <td>
                                <c:if test="${unLivre.disponibilite}">
                                    <span class="dispo"><b>Disponible</b></span>
                                </c:if> <c:if test="${!unLivre.disponibilite}">
                                    <span class="rupture"><b>Rupture</b></span>
                                </c:if>
                                <br>
                                Prix : <b>${unLivre.prixHTLivre} €</b>
                            </td>
                            <td>
                                Ajouter au panier
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5">Catalogue Librairie Fusion</td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </center>
</body>
</html>


