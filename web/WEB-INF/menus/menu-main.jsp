<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
<table>
    <div id="conteneur-menu2">
        <ul>
            <li>  <c:url value="ControllerMain?section=home" var="url01" />
                <a href="${url01}">Accueil</a>
            <li>
                <c:url value="ControllerMain?section=afficher-pays" var="url02" />
                <a href="${url02}"> Pays </a>
            </li>
            <li>
                <c:url value="ControllerMain?section=catalogue" var="url03" />
                <a href="${url03}"> Catalogue </a>
            </li>
            <li> 
                <c:url value="ControllerMain?section=Evenement" var="url04" />
                <a href="${url04}"> Evenement</a>
            </li>
            <li> 
                <c:url value="ControllerMain?section=order" var="url05" />
                <a href="${url05}"> Mes commandes</a>
            </li>
        </ul>
    </div>
</table>
<hr>
<c:url value="ControllerMain?section=Recherche" var="url05" />
<div align="center"/>
<form action="recherche.jsp" method="post">
    <input type="hidden" name="searchLang" value="fra" />
    <input type="text" name="rapid-search" value=""
           placeholder="Trouvez un livre, un auteur, un éditeur, un genre" 
           required="required" autocomplete="off" size="50"/>
    <a href="${url05}">
        <input type="submit" value="Ok" name="doIt" />
    </a>  
</form>
</div>

