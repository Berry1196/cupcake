<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         kurv
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">

            <td> ID: ${cake.cakeIndex} - Antal: ${cake.quantity}- Stk: ${cake.cakePrice}kr -
                Topping: ${cake.topping.toppingName} - Bottom: ${cake.bottom.bottomName} - Total: ${cake.totalCakePrice}kr

                <form action="editcart" method="post">

                    <button name="cakeIndex" value="${cake.cakeIndex}">
                        Rediger
                    </button>

                </form>

                <form action="deletefromcart" method="post">

                    <button name="cakeIndex" value="${cake.cakeIndex}">
                        Slet
                    </button>

                </form>


            </td>
            <br>

        </c:forEach>
        <br>

        Ialt : ${sessionScope.shoppingCart.totalCartPrice}kr


        <a href="betaling.jsp">
            <button> Til kassen</button>
        </a>


    </jsp:body>

</t:pagetemplate>