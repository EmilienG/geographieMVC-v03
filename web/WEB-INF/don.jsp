<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceuil Fusion !</title>
    </head>
    <body>
    <center>
        <h1><span>Page d'Acceuil !</span></h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <div id="cgu">
            Merci vous venez de faire un autre don !
            <br>
           <a href="ControllerMain?section=don">Faire un autre don !!!</a>
        </div>
        <br>
        <img src="/LibrairieFusion-v1.0/img/lib.png"/>
        <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />
    </center>
</body>
</html>