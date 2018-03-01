<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="menu">
    <li>
        <c:url value="ControllerMain?section=home" var="url01" />
        <a href="${url01}">home</a> 
    </li>
    <li>
        <c:url value="ControllerMain?section=afficher-pays" var="url02" />
        <a href="${url02}">pays</a>
    </li>
    <li>
        <c:url value="ControllerMain?section=catalogue" var="url03" />
        <a href="${url03}">catalogue</a>
    </li>

    
    <li>
        <c:url value="ControllerMain?section=Evenement" var="url04" />
        <a href="${url04}">Evenement</a>
    </li>
    </ul>
    <form action="ControllerMain?section=Recherche" method="post">
        <input type="hidden" name="section" value="Recherche" />
        <div align="center"/><input type="text" name="recherche" value=""
        placeholder="Trouvez un livre, un auteur, un éditeur, un genre" 
        required="required" size="50"/>
        <a href="${url05}"><input type="submit" value="Ok" name="doIt" /></a>     
    </form>
    
