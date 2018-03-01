<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1><span> Hello recherche sinon ca marche pas</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url04"/>    
            <c:import url="${url04}"/>
        </nav>
        <table id="tableau">
            <tr>
                <td> 
                    <c:forEach var="maRecherche" items="${mesResultats}">    
                        <span class="titre" >
                            <a href="#"><b>${maRecherche.titreLivre}</b></a>
                                    ${maRecherche.sousTitreLivre}
                        </span>
                        <span class="titre" >
                            <span class="parution">${maRecherche.prenomAuteur}</span>
                        </span>
                        <hr>  
                        <span class="couverture" >
                            <img src="${path}${maRecherche.couvertureLivre}" alt="${maRecherche.couvertureLivre}"  width="150"/>                                      
                        </span>
                        <span class="Auteur">
                            <i>${maRecherche.prenomAuteur}</i>
                            <i>${maRecherche.nomAuteur}</i>
                            <a href="#">[+info]</a>
                        </span>
                        <br>
                        <span class="motCle">Mots Clé : ${maRecherche.descriptionMotClef}</span>
                    </c:forEach>
                </td>
            </tr>                
        </table>
    </body>
</html>
