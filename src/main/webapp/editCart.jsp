<%--
  Created by IntelliJ IDEA.
  User: sutsk
  Date: 09/11/2022
  Time: 12.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditItem</title>
</head>
<body>


<td> ID: ${requestScope.cake.cakeIndex} - Antal: ${requestScope.cake.quantity}- Stk: ${requestScope.cake.cakePrice}kr -
    Topping: ${requestScope.cake.topping.toppingName} - Bottom: ${requestScope.cake.bottom.bottomName} -
    Total: ${requestScope.cake.totalCakePrice}kr


</body>
</html>
