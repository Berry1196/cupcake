<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Betaling
    </jsp:attribute>

    <jsp:body>

        <p>Din indkøbskurv</p>


        <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">

            <td> ID: ${cake.cakeIndex} - Antal: ${cake.quantity}- Stk: ${cake.cakePrice}kr -
                Topping: ${cake.topping.toppingName} - Bottom: ${cake.bottom.bottomName} - Total: ${cake.totalCakePrice}kr
            </td>
            <br>

        </c:forEach>
        <br>

        Total beløb inkl. moms : ${sessionScope.shoppingCart.totalCartPrice}kr

        <form action="payment" method="post">
            <button>
                Betal
            </button>
            <br>
                ${requestScope.besked} ${requestScope.link}
        </form>


    </jsp:body>

</t:pagetemplate>