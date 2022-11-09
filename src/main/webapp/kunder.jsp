<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         kunder
    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>


        <p>You should be logged in now</p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="login.jsp">Login</a></p>
        </c:if>


        HER:
        <c:forEach var="bottom" items="${requestScope.bottomList}">

            <td> ${bottom.bottomId} - ${bottom.bottomName} - ${bottom.bottomPrice}</td>

        </c:forEach>


        HER:
        <c:forEach var="topping" items="${requestScope.toppingList}">

            <td> ${topping.toppingId} - ${topping.toppingName} - ${topping.topppingPrice}</td>

        </c:forEach>
        <div class="light-grey">
            <div class="row">
                <div class="col-4 form-group inline ">
                    <select class="form-select" id="tops" aria-label=".form-select-lg example">
                        <option selected>Open this select menu</option>
                        <option value="1">Choko</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="col-4 form-group inline ">
                    <select class="form-select" id="bots" aria-label=".form-select-lg example">
                        <option selected>Open this select menu</option>
                        <option value="1">Choko</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="col-2 form-group inline ">
                    <select class="form-select" id="quantity" aria-label=".form-select-lg example">
                        <option selected>Open this select menu</option>
                        <option value="1">Choko</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
            </div>
        </div>


    </jsp:body>

</t:pagetemplate>