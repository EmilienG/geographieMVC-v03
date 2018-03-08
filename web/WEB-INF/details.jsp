<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails Oeuvre</title>
    </head>
    <body>
    <center>
        <h1><span>Info sur ce livre</span></h1>
        <c:url value="ControllerMain?section=menu-main" var="url01" />
        <c:import url="${url01}" />
        <table id="wiss">
            <tr>
                <td> 

                    <span class="isbn"><i>ISBN:${monLivre.ISBNlivre}</i></span>
                    <hr>
                    <span class="titre" >
                        <b>${monLivre.titreLivre}</b><br>${monLivre.sousTitreLivre}
                    </span>
                    <hr>
                    <span class="titre" >
                        <span class="parution">(Parution : ${monLivre.dateParutionLivre})</span>
                    </span>
                    <hr>  
                    <span class="couverture" >
                        <img src="${path}${monLivre.couvertureLivre}" alt="${monLivre.couvertureLivre}"  width="150"/>                                      
                    </span>
                    <hr>
                </td> 
                <td>
                    <span class="resume">
                        <i>${monLivre.resumeLivre}</i>
                    </span>
                    <hr>
                    <span class="nbPages">
                        <i>${monLivre.NBPageLivre}</i> Pages.
                    </span>
                    <hr>
                    <span class="gabari">
                         <b>format : </b> <i>${monLivre.gabariLivre}</i>
                    </span>
                    <hr>
                    <span class="poids">
                       <i>${monLivre.poidsLivre}</i> Grammes.
                    </span>
                    <hr>
                    <span class="prenomAuteur">
                        <b>Auteur :</b> <i>${monLivre.prenomAuteur}  ${monLivre.nomAuteur}</i>
                    </span>
                    <hr>
                    
                    <span>
                         <b>Editeur :  </b><i>${monLivre.nomEditeur}</i>
                    </span>

                </td>
                <td>

                    <span class="motCle">Mots Clé : ${monLivre.descriptionMotClef}</span>
                    <hr>
                    Prix : <b>${monLivre.prixHTLivre} €</b>
                    <hr>
                    <c:if test="${monLivre.disponibilite}">
                        <span class="dispo">
                            <b>Disponible</b>
                        </span>
                        <hr>
                        <span class="button">
                            <a href="ControllerMain?section=panier&IDLivre=${monLivre.IDLivre}">
                                <img src="img/detailOrder.jpg"/>
                            </a>
                        </span>
                    </c:if> 
                    <c:if test="${!monLivre.disponibilite}">
                        <span class="rupture"><b>Rupture</b></span>
                    </c:if>
                </td>
            </tr>
        </table>
    </center>
</body>
</html>