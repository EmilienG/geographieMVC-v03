<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="section=login">
</c:if><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
<table id="test">
    <tr>
        <td>
            <div id="conteneur-menu2">
                <ul>

                    <li>  <c:url value="ControllerMain?section=home" var="url01" />
                        <a href="${url01}">Accueil</a>
                        <div align="right"><c:url value="ControllerMain?section=login" var="url07" />
                        <a href="${url07}"> MonCompte </a></div>
                    <li>
                        <c:url value="ControllerMain?section=afficher-pays" var="url02" />
                        <a href="${url02}"> Pays </a>

                    </li>
                    <li>
                        <c:url value="ControllerMain?section=catalogue" var="url03" /><a href="${url03}">Catalogue </a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=Evenement" var="url04" /><a href="${url04}">Evenement</a>
                    </li>
                    <li> 
                        <c:url value="ControllerMain?section=order" var="url05" /><a href="${url05}">Commandes</a>
                    </li>
                </ul>
            </div>
      </td>

        <td>
            <div align="center">
    <form action="ControllerMain?section=Recherche" method="post">
        <input type="hidden" name="section" value="Recherche" />
        <input type="hidden" name="section" value="RechercheEvenement" />
         <input type="text" name="recherche" value=""
               placeholder="Trouvez un livre, un auteur, un éditeur, un genre" 
               required="required" size="50"/>
         <!-- <a href="${url06}"><input type="submit" value="Ok" name="doIt" /></a> -->
                    <span class="bouton4"><input type="submit" value="Ok" name="doIt" /></span>
    </form>
                </div>  <c:if test="section=login" var="def">
                     <jsp:include page="/ControllerMain?section=login" flush="true"/>
                </c:if>
           </td>

        
        <td>
            <div id="conteneur-menu2">
                <ul>
                    <li>
                        <c:url value="ControllerMain?section=panier" var="url06" /><a href="${url06}">Panier</a>
                    <li>
                        <c:url value="ControllerMain?section=compte" var="url07" /><a href="${url07}">Compte</a>
                    </li>
                    <li>
                        <c:url value="ControllerMain?section=logIn" var="url08" /><a href="${url08}">Log-In</a>
                    </li>
                    <li>
                        <c:url value="ControllerMain?section=logOut" var="url09" /><a href="${url09}">Log-Out</a>
                    </li>
                    </li>
                    <li>
                        <c:url value="ControllerMain?section=inscription" var="url10" /><a href="${url10}">S'inscrire</a>
                    </li>
                </ul>
            </div>
        </td>
    </tr>
</table>