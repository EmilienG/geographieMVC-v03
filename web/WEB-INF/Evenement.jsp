
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
        <table>
            <tr>


                <c:forEach var="unEvenement" items="${mesEvenements}">

                <br>

                <td>

                    ${unEvenement}

                </td>

                </br>

            </c:forEach>

        </tr>
    </table>




</body>
</html>

