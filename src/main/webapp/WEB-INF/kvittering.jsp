<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kvittering
    </jsp:attribute>

    <jsp:body>
        <table class="table table-striped text-center">
            <thead>
            <tr>
                <th>Ordre ID</th>
                <th>Cupcake</th>
                <th>Antal</th>
                <th>Dato</th>
                <th>Total pris</th>
                <th>Status</th>
            </tr>
            </thead>

            <tr>
                <td>

                    ${sessionScope.order.order_id}
                </td>
                <td>
                    <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                             ${cake.bottom.bottomName} bottom with ${cake.topping.toppingName} topping <br>
                    </c:forEach>

                </td>
                <td>
                    <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                        ${cake.quantity} stk. <br>
                    </c:forEach>

                </td>
                <td>
                        ${sessionScope.order.date}
                </td>
                <td>
                        ${sessionScope.shoppingCart.totalCartPrice},- kr.
                </td>
                <td>
                    Vi går straks i gang <br> med at bage kagerne!
<%--                        ${sessionScope.order.done}--%>
                </td>
            </tr>
        </table>

    </jsp:body>

</t:pagetemplate>