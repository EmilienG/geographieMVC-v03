
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
            <thead>
                <tr>
                    <td colspan="5">Mon Catalogue Fusion</td>
                </tr>
            <th scope="col">
                Nos Evenements
            </th>

            </thead>
            <tbody>

                <c:forEach var="unEvenement" items="${mesEvenements}">

                <th>
                <tr> <td> ${unEvenement.nomEvenement} </td>  </tr>
                <tr> <td> ${unEvenement.dateDebutEvenement} </td> </tr>
                <tr> <td> ${unEvenement.dateFinEvenement} </td> </tr>
                <tr> <td> ${unEvenement.typeEvenement} </td> </tr>
                <tr> <td> ${unEvenement.descriptionEvenement} </td> </tr>
                <tr> <td> ${unEvenement.commentaireEvenement} </td> </tr>
                <tr> <td> ${unEvenement.titreLivre} </td> </tr>
                <tr> <td> ${unEvenement.ISBNLivre} </td> </tr>
                <img src="${path}${unLivre.couvertureLivre}" alt="${unLivre.couvertureLivre}"  width="150"/>  
                </th>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">Librairie Fusion Since 2018</td>
                </tr>
            </tfoot>

        </table>
    </center>
    <footer>
 Merci de votre visite à bientot
    </footer>
</body>
</html>