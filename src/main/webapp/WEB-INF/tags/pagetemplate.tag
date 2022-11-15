<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <div class="container pt-1">
        <div class="row">
            <c:if test="${sessionScope.user != null && sessionScope.user.role == 'admin' }">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/toadmin">
                    <img src="${pageContext.request.contextPath}/images/olskercupcakes.png" width="1800px;"
                         class="img-fluid center-block"/>
                </a>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <a class="navbar-brand" href="index.jsp">
                    <img src="${pageContext.request.contextPath}/images/olskercupcakes.png" width="1800px;"
                         class="img-fluid center-block"/>
                </a>
            </c:if>
            <c:if test="${sessionScope.user != null && sessionScope.user.role != 'admin'}">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/towelcome">
                    <img src="${pageContext.request.contextPath}/images/olskercupcakes.png" width="1800px;"
                         class="img-fluid center-block"/>
                </a>
            </c:if>
        </div>
    </div>
</header>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

            <div class="navbar-nav pe-2">
                <c:if test="${sessionScope.user != null}">
                    <a class="nav-item nav-link">${sessionScope.user.username}</a>
                    <a class="nav-item nav-link">Saldo: ${sessionScope.user.balance},- kr.</a>
                </c:if>
            </div>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <c:if test="${sessionScope.user != null && sessionScope.user.role == 'admin' }">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/orders">Kunder</a>
                </c:if>

                <c:if test="${sessionScope.user == null }">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/index.jsp">Login</a>
                </c:if>

                <c:if test="${sessionScope.user != null && sessionScope.user.role != 'admin'}">
                    <a class="nav-item nav-link"
                       href="${pageContext.request.contextPath}/shoppingCartServlet">Kurv</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/ordersUser">Ordre</a>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                </c:if>
            </div>
        </div>
    </nav>
</div>


<div id="body" class="container mt-2" style="min-height: 400px;">
    <h1>
        <jsp:invoke fragment="header"/>
    </h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container mt-3">
    <hr/>
    <div class="row mt-4 mb-5">
        <div class="col">
            Roev 313<br/>
            3700 Rønne
        </div>
        <div class="text-center col">
            <p>&copy; 2022 Olsker Cupcakes</p>
        </div>
        <div class="text-end col">
            Olsker Cupcakes Incorporated<br/>
        </div>
    </div>

</div>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>