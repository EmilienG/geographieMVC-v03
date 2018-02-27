<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<ul class="menu">
    <li>
        <c:url value="ControllerMain" var="url01" />
        <a href="${url01}">home</a> 
    </li>
    <li>
        <c:url value="ControllerMain?section=afficher-pays" var="url02" />
        <a href="${url02}">pays</a>
    </li>
    
    <li>
        <c:url value="ControllerMain?section=catalogue" var="url03" />
        <a href="${url03}">Catalogue</a>
    </li>
</ul>