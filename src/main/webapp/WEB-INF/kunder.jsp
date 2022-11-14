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

        <form method="post">
            <h3>Behandles</h3>


            du trykkede på ordre id: ${requestScope.malene}
            størrelse: ${requestScope.getOrders.size()}
            <br>
            her: ${requestScope.test}
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Ordre ID</th>
                    <th>Kunde</th>
                    <th>Cupcake</th>
                    <th>Antal</th>
                    <th>Dato</th>
                    <th>Total Pris</th>
                    <th>Status</th>
                </tr>
                </thead>

                <c:forEach var="order" items="${requestScope.getMalene}">
                    <c:if test="${order.value.done == false}">

                        <tr>
                            <td>
                                    ${order.value.order_id}   ordre id

                            </td>
                            <td>
                                    ${order.value.username}  kunde

                            </td>
                            <td>
                                    <%--                                    ${order.key.cakesInCart.get(cakeIndex).topping.toppingName}--%>
                                    <%--                                - ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName} cupcake--%>
                                    <%--                                <br>--%>
                                    <%--                              --%>


                                    <c:forEach var="kageListen" items="${order.value.cakeArrayList}">
                                        ${kageListen.topping.toppingName} -  ${kageListen.bottom.bottomName} cupcake
                                        <br>
                                    </c:forEach>


                            </td>
                            <td>
<%--                                <c:forEach var="ordre" items="${requestScope.getMalene}">--%>

<%--                                    <c:forEach var="kageListen" items="${ordre.value.cakeArrayList}">--%>
<%--                                        ${kageListen.quantity} stk <br>--%>
<%--                                    </c:forEach>--%>
<%--                                </c:forEach>--%>

                                antal

                            </td>
                            <td>
                                    ${order.value.date} dato

                            </td>
                            <td>
                                        total pris
                            </td>
                            <td>

                                <button formaction="toggleitem" name="order_id" value="${order.value.order_id}">
                                    Klar til udlevering
                                </button>

                                <button formaction="vis" name="malene" value="${order.value.order_id}">
                                    vis
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
                <th>Cupcake</th>
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
                    <td>
                            ${sessionScope.cakeIndex} ${order.key.cakesInCart.get(cakeIndex).topping.toppingName} ${order.key.cakesInCart.get(cakeIndex).bottom.bottomName}
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

                        <button formaction="toggleitem" name="order_id" value="${order.value.order_id}">
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