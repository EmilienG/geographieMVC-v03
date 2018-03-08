<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h1><span>Hello Panier !</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        Ici le panier
        <hr>
        <table>
            <tr>
                <td> 
                    <span class="isbn"><i>ISBN:${monLivre2.ISBNlivre}</i></span>
                    <hr>
                    <a href="ControllerMain?section=details&IDLivre=${monLivre2.IDLivre}">
                        <span class="titre" >
                            <b>${monLivre2.titreLivre}</b><br>${monLivre2.sousTitreLivre}
                        </span>
                    </a>
                    <hr>
                    <span class="titre" >
                        <span class="parution">(Parution : ${monLivre2.dateParutionLivre})</span>
                    </span>
                    <hr>  
                    <span class="couverture" >
                        <img src="${path}${monLivre2.couvertureLivre}" alt="${monLivre2.couvertureLivre}"  width="150"/>                                      
                    </span>
                    <hr>
                    <span class="resume">
                        <i>${monLivre2.resumeLivre}</i>
                    </span>
                </td>
                <td>
                    <span class="motCle">Mots Clé : ${monLivre2.descriptionMotClef}</span>
                    <hr>
                    Prix : <b>${monLivre2.prixHTLivre} €</b>
                    <hr>
                    <c:if test="${monLivre2.disponibilite}">
                        <span class="dispo">
                            <b>Disponible</b>
                        </span>
                        <hr>
                        <span class="button">
                            <a href="ControllerMain?section=panier&IDLivre=${monLivre2.IDLivre}">
                                <img src="img/detailOrder.jpg"/>
                            </a>
                        </span>
                    </c:if> 
                    <c:if test="${!monLivre2.disponibilite}">
                        <span class="rupture"><b>Rupture</b></span>
                    </c:if>
                </td>
            </tr>
        </table>
    </center>
    <c:url value="ControllerMain?section=footer" var="url02" />
    <c:import url="${url02}" />
</body>
</html>