
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evenement</title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <center>
        <h1>
            <span>Evenement</span>
        </h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <table  id="tableau">
            <tr>

<br>
                <c:forEach var="unEvenement" items="${mesEvenements}">

                <br>

                <td>



                     ${unEvenement}

                </td>

                </br>

            </c:forEach>
<br>
        </tr>
    </table>




</body>
</html>

