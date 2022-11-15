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


        <table class="table table-striped">
            <thead>
            <tr class="text-end">
                <th>Antal</th>
                <th>Stk pris</th>
                <th></th>
                <th class="text-center">Top</th>
                <th class="text-center">Bund</th>
                <th></th>
                <th></th>
                <th></th>
                <th>Total</th>
            </tr>
            </thead>


            <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                <tr class="text-end">
                    <td>${cake.quantity} x</td>
                    <td>${cake.cakePrice} kr</td>
                    <td></td>
                    <td class="text-center">${cake.topping.toppingName}</td>
                    <td class="text-center">${cake.bottom.bottomName}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td> ${cake.totalCakePrice},- kr.</td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
            <tr>
                <c:forEach begin="1" end="11" varStatus="loop">
                    <td></td>
                </c:forEach>
            </tr>
            <tr class="text-end">
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td class="text-end pt-3"><b>Den totale pris inkl. moms: </b></td>
                <td></td>
                <td></td>
                <td class="pt-3">${sessionScope.shoppingCart.totalCartPrice},- kr.</td>

                <td>
                </td>

                <td>
                    <form action="payment" method="post">
                        <button type="submit" class="btn purple kurvTekst">
                            Betal
                        </button>
                        <br>
                    </form>
                    <c:if test="${sessionScope.user.balance < sessionScope.shoppingCart.totalCartPrice}">
                        ${requestScope.besked}
                    </c:if>
                </td>

            </tr>
        </table>

    </jsp:body>

</t:pagetemplate>