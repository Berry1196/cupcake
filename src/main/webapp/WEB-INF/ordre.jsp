<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Ordre
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
                <tr>
                    <td>
                            ${order.value.order_id}
                    </td>
                    <td>
                            ${order.key.cakesInCart.get(cakeIndex).topping.toppingName}
                        - ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} cupcake
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
                            ${order.value.done}
                    </td>
                </tr>
            </c:forEach>
        </table>


    </jsp:body>

</t:pagetemplate>