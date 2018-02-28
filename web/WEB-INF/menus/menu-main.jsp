<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
<ul class="menu">
    <li>
        <c:url value="ControllerMain?section=home" var="url01" />
        <a href="${url01}"><b>< Home ></b></a> 
    </li>
    <li>
        <c:url value="ControllerMain?section=afficher-pays" var="url02" />
        <a href="${url02}"><b>< Pays ></b></a>
    </li>
    <li>
        <c:url value="ControllerMain?section=catalogue" var="url03" />
        <a href="${url03}"><b>< Catalogue ></b></a>
    </li>
    <li>
        <c:url value="ControllerMain?section=Evenement" var="url04" />
        <a href="${url04}"><b>< Evenement ></b></a>
    </li>
</ul>
        <br>
<c:url value="ControllerMain?section=Recherche" var="url05" />
<form action="recherche.jsp" method="post">
    <input type="hidden" name="searchLang" value="fra" />
    <div align="center"/>
    <input type="text" name="rapid-search" value=""
           placeholder="Trouvez un livre, un auteur, un éditeur, un genre" 
           required="required" autocomplete="off" size="50"/>
    <a href="${url05}"><input type="submit" value="Ok" name="doIt" /></a>  
</div>
</form>

