<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
     Oversigt over kundeordrer
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>
        <br>

        <h4> Her kan du fylde penge på kontoen</h4>

        <form action="addMoney" method="post">
            <label for="username">Brugernavn: </label>
            <input type="text" id="username" name="username"/>
            <label for="amount">Indbetal til konto: </label>
            <input type="number" id="amount" name="amount"/>
            <button type="submit" value="Indbetal" class="btn purple kurvTekst">Indbetal<button/>
        </form>


        <form method="post">
            <h3>Behandles</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Ordre ID</th>
                    <th>Kunde</th>
                    <th></th>
                    <th>Cupcake</th>
                    <th></th>
                    <th>Antal</th>
                    <th>Dato</th>
                    <th>Total Pris</th>
                    <th>Status</th>
                </tr>
                </thead>

                    <%--                            Map(shoppingcart, ordet)--%>
                <c:forEach var="order" items="${requestScope.adminOrderList}">
                    <c:if test="${order.value.done == false}">
                        <tr>
                            <td>
                                    ${order.value.order_id}
                            </td>
                            <td>
                                    ${order.value.username}
                            </td>
                            <td></td>
                            <td>

                                    ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} bottom
                                with ${order.key.cakesInCart.get(cakeIndex).topping.toppingName} topping

                            </td>
                            <td></td>
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

                                <button formaction="toggleitem" name="order_id" value="${order.value.order_id}"
                                        class="btn purple kurvTekst">
                                    Klar til udlevering
                                </button>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>

        </form>

        <h3>Klar til udlevering</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Ordre ID</th>
                <th>Kunde</th>
                <th></th>
                <th>Cupcake</th>
                <th></th>
                <th>Antal</th>
                <th>Dato</th>
                <th>Total Pris</th>
                <th>Status</th>
            </tr>
            </thead>

            <form method="post">
                <c:forEach var="order" items="${requestScope.adminOrderList}">
                <c:if test="${order.value.done == true}">
                <tr>
                    <td>
                            ${order.value.order_id}
                    </td>
                    <td>
                            ${order.value.username}
                    </td>
                    <td></td>
                    <td>
                            ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} bottom
                                with ${order.key.cakesInCart.get(cakeIndex).topping.toppingName} topping
                    </td>
                    <td></td>
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

                        <button formaction="toggleitem" name="order_id" value="${order.value.order_id}"
                                class="btn purple kurvTekst ps-5 pe-5">
                            Fortryd
                        </button>
                    </td>
                </tr>
                </c:if>
                </c:forEach>
        </table>
        </form>


    </jsp:body>

</t:pagetemplate>