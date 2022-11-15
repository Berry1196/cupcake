<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Valgte varer i kurv
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

       <br>

        <table class="table table-striped">
            <thead>
            <tr class="text-end">
                <th>Antal</th>
                <th>Stk pris</th>
                <th class="text-center">Top</th>
                <th class="text-center">Bund</th>
                <th></th>
                <th>Total</th>

            </tr>
            </thead>


            <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                <tr class="text-end">
                    <td>${cake.quantity} x </td>
                    <td>${cake.cakePrice} kr</td>
                    <td class="text-center">${cake.topping.toppingName}</td>
                    <td class="text-center">${cake.bottom.bottomName}</td>
                    <td> </td>
                    <td> ${cake.totalCakePrice} kr</td>

                    <td>
                    <form action="editcart" method="post">

                        <button name="cakeIndex" value="${cake.cakeIndex}">
                            Rediger
                        </button>

                    </form>
                    </td>
                    <td>
                    <form action="deletefromcart" method="post">

                        <button name="cakeIndex" value="${cake.cakeIndex}">
                            Slet
                        </button>

                    </form>
                    </td>

                </tr>
            </c:forEach>
            <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr class="text-end">
                <td> </td>
                <td> </td>
                <td></td>
                <td> </td>
                <td class="text-end pt-3" ><b>I alt:</b></td>
                <td class="pt-3" >${sessionScope.shoppingCart.totalCartPrice} kr</td>

                <td>
                    <form action="topayment" method="post" name="${sessionScope.shoppingCart.cakesInCart}">

                        <button type="submit" class="btn btn-primary">
                            Til kassen
                        </button>
                        <br>

                    </form>
                </td>
                <td>

                </td>

            </tr>
        </table>


    </jsp:body>

</t:pagetemplate>