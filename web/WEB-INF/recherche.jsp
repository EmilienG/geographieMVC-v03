<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="recherche.jsp" method="post">
    <input type="hidden" name="searchLang" value="fra" />
        <input type="text" name="rapid-search" value=""
        placeholder="Trouvez un livre, un auteur, un éditeur, un genre" 
        required="required" autocomplete="off"/> 
        <input type="submit" value="Ok" name="doIt" />
</form>