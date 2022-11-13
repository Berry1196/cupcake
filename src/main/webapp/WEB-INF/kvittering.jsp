<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kvittering
    </jsp:attribute>

    <jsp:body>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Ordre ID</th>
                <th>Cupcake</th>
                <th>Antal</th>
                <th>Dato</th>
                <th>Total Pris</th>
                <th>Status</th>
            </tr>
            </thead>

            <tr>
                <td>
<%--                    ${sessionScope.order.order_id}--%>
                    ${sessionScope.order.order_id}
                </td>
                <td>
                    <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                            ${cake.topping.toppingName} -  ${cake.bottom.bottomName} cupcake <br>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                        ${cake.quantity} <br>
                    </c:forEach>

                </td>
                <td>
                        ${sessionScope.order.date}
                </td>
                <td>
                        ${sessionScope.shoppingCart.totalCartPrice} kr.
                </td>
                <td>
                        ${sessionScope.order.done}
                </td>
            </tr>
        </table>

    </jsp:body>

</t:pagetemplate>