<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
        <title>Détails de votre commande</title>
    </head>
    <body>
        <div class="menu-order">
            <h1><span class="sous-menu-order">Votre commande : "numéro"</span></h1>

            <table class='tabOrder'>
                <h3>Vos Commandes</h3>
                <tr>
                <thead>
                <th>Référence</th>
                <th>ISBN</th>
                <th>Titre du livre</th>
                <th>Quantités commandées</th>
                <th>T.V.A</th>
                <th>Prix H.T (€)</th>
                </thead>
                <tbody>
                    <c:forEach items="${gestionLC}" var="oneOrderLine" >
                        <c:forEach items="${gestionLV}" var="oneOrderLinelv" >
                            <tr>
                                <td>
                                    ${oneOrderLine.IDLigneCommande}
                                </td>                   

                                <td>
                                    ${oneOrderLinelv.ISBNlivre}                       
                                </td>
                                <td >
                                    ${oneOrderLinelv.titreLivre}
                                <td>
                                    ${oneOrderLine.quantiteLigneCommande}
                                </td>               
                                <td>  
                                    ${oneOrderLine.TVALigneCommande}
                                </td>
                                <td>
                                    ${oneOrderLine.prixHTLivreLigneCommande}
                                </td>
                            </tr>
                        </c:forEach>
                    </c:forEach>

                </tbody>
                </tr>


            </table>
        </div>
        <c:url value="ControllerMain?section=footer" var="url02" />
        <c:import url="${url02}" />

    </body>
</html>
