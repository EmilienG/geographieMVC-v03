

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Coup De Coeur </title>
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <center>
        <h1>
            <span>Coup De Coeur</span>
        </h1>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <form action="ControllerMain?section=RechercheCoupDeCoeur" method="post">
        <input type="hidden" name="section" value="RechercheCoupDeCoeur" />
        <div align="right"><input type="text" name="rechercheCoupDeCoeur" value=""
                                  placeholder="Trouvez un CoupDeCoeur" 
                                  required="required" size="20"/>
            <a href="${url07}">
                <input type="submit" value="Ok" name="doItCDC" />
            </a>  
    </form>
        <table  id="tableau">
            <thead>
               
            <th scope="col" colspan="20">
                Nos Coup De Coeur
            </th>

            </thead>
            <tbody>

                <c:forEach var="unCoupDeCoeur" items="${mesCoupDeCoeurs}">
                    <tr>
                        <td> ${unCoupDeCoeur.nomCoupDeCoeur} </td>  
                        <td> ${unCoupDeCoeur.descriptionCoupDeCoeur} </td>
                        <td>
                            ${unCoupDeCoeur.titreClean}
                        </td>
                        <td> ${unCoupDeCoeur.ISBNLivre} </td>
               

                </tr>


            </c:forEach>

            </tbody>

            <tfoot>
                <tr>
                    <td colspan="20">Librairie Fusion Since 2018</td>
                </tr>
            </tfoot>

        </table>
    </center>

    <footer>
        <center>
            Merci de votre visite à bientot
        </center>
    </footer>
    
</body>
</html>