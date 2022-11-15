<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>

      <jsp:attribute name="header">
         Rediger valg
    </jsp:attribute>
    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>
    <jsp:body>

        <form action="editcake" method="post">
            <div class="container light-grey pt-3">

                <div class="row">
                    <div class="col  form-group  mt-5 me-5 ms-5">
                        <select class="form-select" name="topping">
                            <option selected>${requestScope.cake.topping.toppingName}</option>
                            <c:forEach var="topping" items="${requestScope.toppingMap.values()}">
                                <option value="${topping.toppingName}"> ${topping.toppingName} ${topping.topppingPrice}kr.</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col form-group  mt-5  me-5 ">
                        <select class="form-select" name="bottom">
                            <option selected>${requestScope.cake.bottom.bottomName}</option>
                            <c:forEach var="bottom" items="${requestScope.bottomMap.values()}">
                                <option value="${bottom.bottomName}">${bottom.bottomName} ${bottom.bottomPrice}kr.</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-2 form-group mt-5 me-4">
                        <select class="form-select" name="quantity" aria-label=".form-select-lg example">
                            <option selected>${requestScope.cake.quantity}</option>
                            <c:forEach begin="1" end="20" varStatus="loop">
                                <option value="${loop.index}">${loop.index}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row">
                        <input type="hidden" name="cakeIndex" value="${requestScope.cake.cakeIndex}" />
                        <div class="text-end mt-3 mb-3">
                            <button type="submit" value="Tilføj til kurv" class="btn purple kurvTekst">Opdater
                            </button>
                        </div>
                    </div>
                </div>
                    ${requestScope.besked}
            </div>
        </form>









<%--        <form action="editcake" method="post">--%>
<%--        <div class="row light-grey">--%>
<%--            <div class="col-4 form-group inline ">--%>
<%--                <select class="form-select" name="topping" aria-label=".form-select-lg example">--%>
<%--                    <option selected>${requestScope.cake.topping.toppingName} </option>--%>
<%--                    <c:forEach var="topping" items="${requestScope.toppingMap.values()}">--%>
<%--                        <option value="${topping.toppingName}"> ${topping.toppingName} ${topping.topppingPrice}kr. </option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="col-4 form-group inline ">--%>
<%--                <select class="form-select" name="bottom" aria-label=".form-select-lg example">--%>
<%--                    <option selected>${requestScope.cake.bottom.bottomName}</option>--%>
<%--                    <c:forEach var="bottom" items="${requestScope.bottomMap.values()}">--%>
<%--                        <option value="${bottom.bottomName}" >${bottom.bottomName} ${bottom.bottomPrice}kr.</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>

<%--            <div class="col-2 form-group inline">--%>
<%--                <select class="form-select" name="quantity" aria-label=".form-select-lg example">--%>
<%--                    <option selected>${requestScope.cake.quantity}</option>--%>
<%--                    <c:forEach begin="1" end="20" varStatus="loop">--%>
<%--                        <option value="${loop.index}">${loop.index}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <input type="hidden" name="cakeIndex" value="${requestScope.cake.cakeIndex}" />--%>
<%--            <div class="text-end">--%>
<%--                <input type="submit" value="Tilføj til kurv"/>--%>
<%--            </div>--%>
<%--        </div>--%>



<%--        DEN totale pris er: ${sessionScope.totalCartPrice}--%>



<%--    </form>--%>





    </jsp:body>

</t:pagetemplate>