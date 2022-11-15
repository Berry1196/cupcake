<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Dine ordrer
    </jsp:attribute>

    <jsp:body>
        <br>
        <h3>Behandles</h3>
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

                <%--                            Map(shoppingcart, ordet)--%>
            <c:forEach var="order" items="${requestScope.orderListUser}">
                <c:if test="${order.value.done == false}">
                    <tr>
                        <td>
                                ${order.value.order_id}
                        </td>
                        <td>
                                ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} bottom
                            with ${order.key.cakesInCart.get(cakeIndex).topping.toppingName} topping
                        </td>
                        <td>
                                ${order.key.cakesInCart.get(cakeIndex).quantity}
                        </td>
                        <td>
                                ${order.value.date}
                        </td>
                        <td>
                                ${order.key.totalCartPrice} kr.
                        </td>
                        <td>
                            Vi er ved at bage dine kager
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>

        <br>
        <h3>Klar til udlevering</h3>
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

                <%--                            Map(shoppingcart, ordet)--%>
            <c:forEach var="order" items="${requestScope.orderListUser}">
                <c:if test="${order.value.done == true}">
                    <tr>
                        <td>
                                ${order.value.order_id}
                        </td>
                        <td>
                                ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} bottom
                            with ${order.key.cakesInCart.get(cakeIndex).topping.toppingName} topping
                        </td>
                        <td>
                                ${order.key.cakesInCart.get(cakeIndex).quantity}
                        </td>
                        <td>
                                ${order.value.date}
                        </td>
                        <td>
                                ${order.key.totalCartPrice} kr.
                        </td>
                        <td>
                            Dine kager er klar til afhentning
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <br>

    </jsp:body>

</t:pagetemplate>