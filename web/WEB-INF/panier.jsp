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
        <h1><span>Panier</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>

        <hr>
        <c:if test="${panierVide}">
            Panier vide !    
        </c:if>
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
                    </c:if> 
                    <c:if test="${!monLivre2.disponibilite}">
                        <span class="rupture"><b>Rupture</b></span>
                    </c:if>

                    <c:if test="${!panierVide}">

                        <c:forEach var="unLivre" items="${uneListeDeLivre}">
                            ${i.ref}/${i.qty}
                            <a href="ControllerMain?section=panier&add&IDLivre2=${unLivre.IDLivre}">+</a>
                            <a href='ControllerMain?section=panier&dec&IDLivre2=${i.ref}'>-</a>
                            <a href='ControllerMain?section=panier&del&IDLivre2=${i.ref}'>X</a>

                            <br>        
                        </c:forEach>
                        <a href='ControllerMain?section=panier&clear'>Vider le panier !</a>         
                    </c:if>
                    
                </td>
            </tr>
        </table>
    </center>
    <c:url value="ControllerMain?section=footer" var="url02" />
    <c:import url="${url02}" />
</body>
</html>