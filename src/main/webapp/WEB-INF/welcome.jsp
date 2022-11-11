<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen ombord!
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user != null}">
            <p>Du er logget på som "${sessionScope.user.username}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget på. Dette kan du gøre her: <a
                    href="../login.jsp">Login</a></p>
        </c:if>


        <form action="addCupcakes" method="post">
            <div class="row light-grey">
                <div class="col-4 form-group inline ">
                    <select class="form-select" name="topping" aria-label=".form-select-lg example">
                        <option selected>Vælg top</option>
                        <c:forEach var="topping" items="${requestScope.toppingMap.values()}">
                            <option value="${topping.toppingName}"> ${topping.toppingName} ${topping.topppingPrice}kr. </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-4 form-group inline ">
                    <select class="form-select" name="bottom" aria-label=".form-select-lg example">
                        <option selected>Vælg bund</option>
                        <c:forEach var="bottom" items="${requestScope.bottomMap.values()}">
                            <option value="${bottom.bottomName}" >${bottom.bottomName} ${bottom.bottomPrice}kr.</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-2 form-group inline">
                    <select class="form-select" name="quantity" aria-label=".form-select-lg example">
                        <c:forEach begin="1" end="20" varStatus="loop">
                            <option value="${loop.index}">${loop.index}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="text-end">
                    <input type="submit" value="Tilføj til kurv"/>
                    <br>
                    ${requestScope.besked}
                </div>
            </div>


            DEN totale pris er: ${sessionScope.totalCartPrice}
            <br>
            <br>
            <c:forEach var="cake" items="${sessionScope.shoppingCart.cakesInCart}">
                Top: ${cake.topping.toppingName} -  Bund: ${cake.bottom.bottomName} - Antal: ${cake.quantity} <br>
            </c:forEach>



        </form>


    </jsp:body>

</t:pagetemplate>