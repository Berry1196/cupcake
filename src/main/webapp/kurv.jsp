<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         kurv
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <p>You should be logged in now</p>


        <c:forEach var="cake" items="${requestScope.shoppingCart}">

            <td> ID: ${cake.cakeIndex} - Antal: ${cake.quantity}- Stk: ${cake.cakePrice}kr - Topping: ${cake.topping.toppingName} - Bottom: ${cake.bottom.bottomName} - Total: ${cake.totalCakePrice}kr

                <form action="editcart" method="post">
                    <label name="toppingName" value="${cake.topping.toppingName}" ></label>
                    <label name="bottomName" value="${cake.bottom.bottomName}" ></label>
                    <label name="quantity" value="${cake.quantity}" ></label>
                    <label name="cakeIndex" value="${cake.cakeIndex}" ></label>

                    <input type="submit" value="Rediger"/>
                </form>

            </td><br>

        </c:forEach>
        <br>

        Ialt : ${requestScope.totalCartPrice}kr







    </jsp:body>

</t:pagetemplate>