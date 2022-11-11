<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Ordre
    </jsp:attribute>

    <jsp:body>

        <p>Oversigt over ordre </p>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Item</th>
                <th>Action</th>
            </tr>
            </thead>





            <c:forEach var="orderList" items="${requestScope.orderList}">
                <tr>
                    <td>
                           <th> Ordre Id: ${orderList.order_id} - Kunde: ${orderList.username} -  Dato: ${orderList.date} - Status: ${orderList.done} - </th>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </jsp:body>

</t:pagetemplate>