<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>


    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <%--<c:if test="${sessionScope.user != null}">
            <p>Du er logget på som "${sessionScope.user.username}".</p>
        </c:if>
--%>
        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget på. Dette kan du gøre her: <a
                    href="../index.jsp">Login</a></p>
        </c:if>

        <form action="addCupcakes" method="post">
            <div class="container light-grey">
                <h1>Øens bedste cupcakes!</h1>
                <h4>Vælg og bestil her:</h4>
                <div class="row">
                    <div class="col  form-group  mt-5 me-5 ms-5">
                        <select class="form-select" name="topping">
                            <option selected>Vælg top</option>
                            <c:forEach var="topping" items="${requestScope.toppingMap.values()}">
                                <option value="${topping.toppingName}"> ${topping.toppingName} ${topping.topppingPrice}kr.</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col form-group  mt-5  me-5 ">
                        <select class="form-select" name="bottom">
                            <option selected>Vælg bund</option>
                            <c:forEach var="bottom" items="${requestScope.bottomMap.values()}">
                                <option value="${bottom.bottomName}">${bottom.bottomName} ${bottom.bottomPrice}kr.</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-2 form-group mt-5 me-4">
                        <select class="form-select" name="quantity">
                            <c:forEach begin="1" end="20" varStatus="loop">
                                <option value="${loop.index}">${loop.index}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row">
                        <div class="text-end mt-3 mb-3">
                            <button type="submit" value="Tilføj til kurv" class="btn purple kurvTekst">Tilføj til kurv
                            </button>
                        </div>
                    </div>
                </div>
                    ${requestScope.besked}

            </div>
        </form>


    </jsp:body>

</t:pagetemplate>