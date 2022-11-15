<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
        <br>
        <br>
    </jsp:attribute>


    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h4>Du kan logge på her</h4>

        <form action="login" method="post">
            <label for="username">Brugernavn: </label>
            <input type="text" id="username" name="username"/>
            <label for="password">Adgangskode: </label>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Log in"/>
            <br>
                ${requestScope.besked}
        </form>

        <br>
        <br>

        <h4>Eller oprette dig som ny kunde</h4>
        <form action="createuserform" method="post">
            <label for="newusername">Email: </label>
            <input type="email" id="newusername" name="newusername"/> <br>
            <label for="newpassword">Adgangskode: </label>
            <input type="password" id="newpassword" name="newpassword"/><br>
            <label for="repnewpassword">Gentag adgangskode: </label>
            <input type="password" id="repnewpassword" name="repnewpassword"/><br>
            <input type="submit" value="Opret"/>
            <br>
                ${sessionScope.besked}
        </form>


    </jsp:body>
</t:pagetemplate>