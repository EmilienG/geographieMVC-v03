<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/LibrairieFusion-v1.0/css/moncss.css" rel="stylesheet" type="text/css"/>
        <title>Mes Commandes</title>
    </head>
    <body>
        <nav>
            <c:url value="ControllerMain?section=menu-main" var="url01" />
            <c:import url="${url01}" />
        </nav>
        <hr />
        <h1><span>Mes Commandes</span></h1>
        <table class='tabOrder'>
            <h3>Vos Commandes</h3>
            <tr>
                <thead>
                    <th>N° Commande</th>
                    <th>Date de votre commande</th>
                    <th>Statut Commande</th>
                    <th>Montant Commande (€)</th>
                    <th>Voir détails de la commande</th>
                </thead>
                <tbody>
                    <c:forEach items="${gestionC}" var="oneOrder" >
                    <tr>
                        <td>
                            ${oneOrder.getIDCommande()}
                        </td>                   
                        <td>
                            ${oneOrder.getDateCommande()}
                        </td>                 
                        <td>
                            ${oneOrder.getDescriptionStatut()}
                        </td>                  
                        <td>
                            ${oneOrder.getMontantCommande()}
                        </td>
                        
                        <td><a href="ControllerMain?section=orderLine"><span class="button"><img src="/LibrairieFusion-v1.0/image/detailOrder.jpg"/></a></span></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </tr>
    
    
</table>
</body>
</html>


