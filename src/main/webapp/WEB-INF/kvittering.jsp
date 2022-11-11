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
                <th>Item</th>
                <th>Action</th>
            </tr>
            </thead>


            <td>
            <th> Ordre Id: ${sessionScope.order.order_id} - Kunde: ${sessionScope.order.username} - Dato: ${sessionScope.order.date} - Status: ${sessionScope.order.done}
                -
            </th>
            </td>

        </table>


    </jsp:body>

</t:pagetemplate>