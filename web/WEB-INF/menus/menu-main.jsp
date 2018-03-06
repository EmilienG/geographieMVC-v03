<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="section=login">
</c:if><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
<h3><c:if test="${logOn}">Connecté</c:if><c:if test="!${logOn}">Deconnecté</c:if></h3> 
    <table id="test">
        <tr>
            <td>
                <div id="conteneur-menu2">
                    <ul>
                            <li>  <c:url value="ControllerMain?section=home" var="url01" />
                        <a href="${url01}">Accueil</a>
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
                     <li> 
                        <c:url value="ControllerMain?section=CoupDeCoeur" var="url07" /><a href="${url07}">Coup De Coeur</a>
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
                    </li>
                    <c:if test="${logOn}" >
                        <li>
                            <c:url value="ControllerMain?section=compte" var="url07" /><a href="${url07}">Compte [${welcome}]</a>
                        </li>
                    </c:if>
                    <c:if test="${!logOn}">
                        <li>
                            <c:url value="ControllerMain?section=login" var="url08" /><a href="${url08}">Log-In</a>
                        </li>
                    </c:if>
                    <c:if test="${logOn}">
                        <li>
                            <c:url value="ControllerMain?section=deconnecter" var="url09" /><a href="${url09}">Log-Out</a>
                        </li>
                    </c:if>
                    <c:if test="${!logOn}">
                        <li>
                            <c:url value="ControllerMain?section=inscription" var="url10" /><a href="${url10}">S'inscrire</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </td>
    </tr>
</table>