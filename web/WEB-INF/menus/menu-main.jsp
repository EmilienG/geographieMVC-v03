<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
<table>
    <tr>
        <td>
            <div id="conteneur-menu2">
                <ul>
                    <li> 
                        <c:url value="ControllerMain?section=home" var="url01" />
                        <a href="${url01}">Accueil</a>
                    <li>
                        <c:url value="ControllerMain?section=afficher-pays" var="url02" />
                        <a href="${url02}">Pays </a>
                    </li>
                    <li>
                        <c:url value="ControllerMain?section=catalogue" var="url03" />
                        <a href="${url03}">Catalogue </a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=Evenement" var="url04" />
                        <a href="${url04}">Evenement</a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=order" var="url05" />
                        <a href="${url05}">Mes commandes</a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=catalogue2" var="url06" />
                        <a href="${url06}">Catalogue2</a>
                    </li>
                </ul>
            </div>
        </td>
        <td>
            <div align="center">
                <form action="ControllerMain?section=Recherche" method="post">
                    <input type="hidden" name="section" value="Recherche" />
                    <input type="text" name="recherche" value="" 
                           placeholder="Trouvez un livre, un auteur, un éditeur, un genre" required="required" size="50"/>
                    <a href="${url05}">
                        <input type="submit" value="Ok" name="doIt" />
                    </a>  
                </form>
            </div>
        </td>
        <td>
            <div id="conteneur-menu2">
                <ul>
                    <li> 
                        <c:url value="ControllerMain?section=panier" var="url08" />
                        <a href="${url01}">Panier</a>
                    <li>
                        <c:url value="ControllerMain?section=monCompte" var="url09" />
                        <a href="${url02}">Mon Compte</a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=logOut" var="url10" />
                        <a href="${url05}">Log Out</a>
                    </li>
                </ul>
            </div>
        </td>
    </tr>
</table>  


