<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         kurv
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <p>You should be logged in now</p>


        <c:forEach var="cake" items="${requestScope.shoppingCart}">

            <td> Antal: ${cake.quantity}- Stk: ${cake.cakePrice}kr - Topping: ${cake.topping.toppingName} - Bottom: ${cake.bottom.bottomName} - Total: ${cake.totalCakePrice}kr</td><br>

        </c:forEach>
        <br>
        Ialt: ${requestScope.shoppingCart.totalCartPrice}kr<br>





    </jsp:body>

</t:pagetemplate>