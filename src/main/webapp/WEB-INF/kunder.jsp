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
                        <td>
                               bund + top
                        </td>
                        <td>
                               antal stk
                        </td>
                        <td>
                                ${order.value.date}

                        </td>
                        <td>
                                ${order.key.totalCartPrice} kr.

                        </td>
                        <td>

                        <button formaction="toggleitem" name="order_id" value="${order.value.order_id}">
                            Done
                        </button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>






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
                                    bund + top
                                </td>
                                <td>
                                    antal stk
                                </td>
                                <td>
                                        ${order.value.date}

                                </td>
                                <td>
                                        ${order.key.totalCartPrice} kr.

                                </td>
                                <td>

                                    <button formaction="toggleitem" name="order_id" value="${order.value.order_id}">
                                        Undo
                                    </button>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>




        </table>


    </jsp:body>

</t:pagetemplate>