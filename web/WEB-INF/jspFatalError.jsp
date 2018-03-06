<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil Fusion !</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
    <center>
        <h1><span> Tricheur, voleur, honte à toi et sur ta famille !!!</span></h1>
        <font color='red'>${fatalError}</font>  
    Maintenant patiente -_- !
    </center>
            <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />
</body>
</html>