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

    <!-- Collapse button-->
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
                <li class="nav-item active">
                    <a class="nav-link" href="#">Список предприятий<span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/personal"/>">Ваши данные<span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Ваши заявки <span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <!--Search form-->
            <form class="form-inline" >
                <input class="form-control" name="search" type="text" placeholder="Search"/>
                <button class="white-text" type="submit"> <i class="fa fa-search"> </i> </button>
            </form>
        </div>
        <!--/.Collapse content-->

    </div>

</nav>

<table class="table">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Type of own-ship</th>
        <th>Work time</th>
        <th>Work days</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Services</th>
        <th>Оставить заявку</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="org" items="${list}">
        <tr>
            <th scope="row">${org.getOrg_id()}</th>
            <td>${org.getName()}</td>
            <td>${org.getType_of_ownership()}</td>
            <td>${org.getWork_time()}</td>
            <td>${org.getWork_days()}</td>
            <td>${org.getAddress()}</td>
            <td>${org.getPhone()}</td>
            <td>

            </td>
            <td>
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"><i class="fa fa-pencil"></i></button>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <!--Content-->
                        <div class="modal-content">
                            <!--Header-->
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <!--Body-->
                            <div class="modal-body">
                                ...
                            </div>
                            <!--Footer-->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                        <!--/.Content-->
                    </div>
                </div>

            </td>
        </tr>
    </c:forEach>

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
