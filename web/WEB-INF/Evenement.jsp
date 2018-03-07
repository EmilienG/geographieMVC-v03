
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
              
            <th scope="col" colspan="20">
                Nos Evenements
            </th>

            </thead>
            <tbody>
                <c:forEach var="unEvenement" items="${mesEvenements}">

                    <tr>

                        <td> ${unEvenement.nomEvenement} </td>  

                        <td> ${unEvenement.dateDebutEvenement} </td> 

                        <td> ${unEvenement.dateFinEvenement} </td>

                        <td> ${unEvenement.typeEvenement} </td> 

                        <td> ${unEvenement.descriptionEvenement} </td>

                        <td> ${unEvenement.commentaireEvenement} </td>

                        <td>
                            ${unEvenement.titreClean}
                        </td>

                        <td> ${unEvenement.ISBNLivre} </td> 

                

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
    <form action="ControllerMain?section=RechercheEvenement" method="post">
        <input type="hidden" name="section" value="RechercheEvenement" />
        <div align="right"><input type="text" name="rechercheEvenement" value=""
                                  placeholder="Trouvez un Evenement" 
                                  required="required" size="20"/>
            <a href="${url06}">
                <input type="submit" value="Ok" name="doItEv" />
            </a>  
    </form>
    <c:url value="ControllerMain?section=footer" var="url02" />
    <c:import url="${url02}" />
</body>

</html>