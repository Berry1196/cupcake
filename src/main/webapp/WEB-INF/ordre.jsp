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

            <c:forEach var="order" items="${requestScope.orderListUser}">
                <c:if test="${order.value.done == false}">
                    <tr>
                        <td>
                                ${order.value.order_id}
                        </td>
                        <td>
                            <c:forEach var="cake" items="${order.key.cakesInCart}">
                                ${cake.bottom.bottomName} bottom with ${cake.topping.toppingName} topping
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="cake" items="${order.key.cakesInCart}">
                                ${cake.quantity} stk.
                            </c:forEach>
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

            <c:forEach var="order" items="${requestScope.orderListUser}">
                <c:if test="${order.value.done == true}">
                    <tr>
                        <td>
                                ${order.value.order_id}
                        </td>
                        <td>
                            <c:forEach var="cake" items="${order.key.cakesInCart}">
                                ${cake.bottom.bottomName} bottom with ${cake.topping.toppingName} topping
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="cake" items="${order.key.cakesInCart}">
                                ${cake.quantity} stk.
                            </c:forEach>
                        </td>
                        <td>
                                ${order.value.date}
                        </td>
                        <td>
                                ${order.key.totalCartPrice} kr.
                        </td>
                        <td>
                            Kagerne er klar til afhentning
                        </td>
                    </tr>
                </c:if>
            </c:forEach>

        </table>

        <br>

    </jsp:body>

</t:pagetemplate>