<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Tank op
        <br>
    </jsp:attribute>



    <jsp:body>

        <h4> Her kan du fylde penge på kontoen</h4>

        <form action="addMoney" method="post">
            <label for="amount">Indbetal til konto: </label>
            <input type="number" id="amount" name="amount"/>

            <input type="submit" value="Indbetal"/>
        </form>

    </jsp:body>
</t:pagetemplate>