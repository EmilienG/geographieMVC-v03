<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
    <center>
        <h1><span>Catalogue</span></h1>
        <c:url value="ControllerMain?section=menu-main" var="url01" />
        <c:import url="${url01}" />
        <div style="overflow-x:auto;">
            <table  id="tableau">
                <thead>
                    <tr>
                        <td colspan="12">Mon Catalogue Fusion</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  var="uneListeDeListe" items="${listDeListDeList}">
                        <tr>
                            <c:forEach  var="uneListeDeLivre" items="${uneListeDeListe}">
                                <c:forEach  var="unLivre" items="${uneListeDeLivre}">
                                    <td> 
                                        <span class="isbn"><i>ISBN:${unLivre.ISBNlivre}</i></span>
                                        <hr>
                                        <span class="titre" >
                                            <a href="#"><b>${unLivre.titreLivre}</b><br>${unLivre.sousTitreLivre}</a>
                                        </span>
                                        <hr>
                                        <span class="titre" >
                                            <span class="parution">(Parution : ${unLivre.dateParutionLivre})</span>
                                        </span>
                                        <hr>  
                                        <span class="couverture" >
                                            <img src="${path}${unLivre.couvertureLivre}" alt="${unLivre.couvertureLivre}"  width="150"/>                                      
                                        </span>
                                        <hr>
                                        <span class="resume">
                                            <i>${unLivre.resumeCourt}(...)</i>
                                            <a href="#">[+info]</a>
                                        </span>
                                    </td>
                                    <td>
                                        <span class="motCle">Mots Clé : ${unLivre.descriptionMotClef}</span>
                                        <hr>
                                        Prix : <b>${unLivre.prixHTLivre} €</b>
                                        <hr>
                                        <c:if test="${unLivre.disponibilite}">
                                            <span class="dispo"><b>Disponible</b></span>
                                        </c:if> 
                                        <c:if test="${!unLivre.disponibilite}">
                                            <span class="rupture"><b>Rupture</b></span>
                                        </c:if>
                                    </td>
                                    <td>
                                        Add panier
                                    </td>
                                </c:forEach> 
                            </c:forEach> 
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="12">Catalogue Librairie Fusion</td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <a href="#">page 1</a>| <a href="#">page 2</a>| <a href="#">page 3</a>|  <a href="#">...</a>
    </center>
</body>
</html>


