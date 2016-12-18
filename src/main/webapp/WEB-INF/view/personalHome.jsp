<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Customer: UseR7
  Date: 05.10.2016
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.css"/>" rel="stylesheet">

    <!-- Your custom styles (optional) -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

    <title>Your page</title>
</head>
<body>
<nav class="navbar navbar-dark primary-color-dark">

    <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse" data-target="#collapseEx">
        <i class="fa fa-bars"></i>
    </button>

    <div class="container">

        <!--Collapse content-->
        <div class="collapse navbar-toggleable-xs" id="collapseEx">
            <!--Navbar Brand-->
            <a class="navbar-brand" href="<c:url value="/home"/>">Справочник потребителя</a>
            <!--Links-->
            <ul class="nav navbar-nav">
                <li class="nav-item ">
                    <a class="nav-link" href="<c:url value="/home"/>">Список предприятий<span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">Ваши данные <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Ваши заявки <span class="sr-only">(current)</span></a>
                </li>

            </ul>

        </div>
        <!--/.Collapse content-->

    </div>

</nav>

<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>City</th>
        <th>Phone</th>
        <th>Редактировать/Удалить аккаунт</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td> <c:if test="${not empty name}">${name} </c:if></td>
        <td> <c:if test="${not empty city}">${city} </c:if></td>
        <td> <c:if test="${not empty phone}">${phone}</c:if></td>
        <td>
            <button class="teal-text"  href="<c:url value="/personal"/>"><i class="fa fa-pencil"></i></button>
            <button class="red-text"><i class="fa fa-times"></i></button>
        </td>
    </tr>


    </tbody>
</table>


<!-- Bootstrap tooltips -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>

<!-- MDB core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/mdb.js"/>"></script>
</body>
</html>