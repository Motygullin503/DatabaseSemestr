<%--
  Created by IntelliJ IDEA.
  User: UseR7
  Date: 28.09.2016
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="<c:url value="/css/mdb.css"/>" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="<c:url value="/form.css"/>">

    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>

<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>


<form action="" id="reg" name='registration' method="POST">

    <h2>Register</h2>
    <p>Enter fullname (required, at least 3 characters, 40 symbols max)</p>
    <div class="md-form">
        <i class="fa fa-user fa-3x prefix"></i>
        <input type="text" name="fullname" id="fullname" class="form-control"
               <c:if test="${not empty name}">value="${name}" </c:if>>
        <label for="fullname" class="">for example: Aaron Smith</label>
    </div>

    <p>Enter Email (required)</p>
    <div class="md-form">
        <i class="fa fa-envelope prefix"></i>
        <input type="text" name="email" id="email" class="form-control"
               <c:if test="${not empty email}">value="${email}" </c:if>>
        <label for="email" class="">example@example.com</label>
    </div>
    <p>Enter password </p>
    <div class="md-form">
        <i class="fa fa-lock prefix"></i>
        <input type="password" name="password" id="password" class="form-control"
               <c:if test="${not empty password}">value="${password}" </c:if>>
        <label for="password" class="">(required, at least 3 characters) </label>
    </div>

    <p>Enter password again</p>
    <div class="md-form">
        <i class="fa fa-lock prefix"></i>
        <input type="password" name="password2" id="password2" class="form-control"
               <c:if test="${not empty password2}">value="${password2}" </c:if>>
        <label for="password2" class="">You're not robot, right?</label>
    </div>
    <p>Input your city</p>
    <div class="md-form">
        <i class="fa fa-map-marker prefix"></i>

        <input type="text" name="city" id="city_select" class="form-control"
            <c:if test="${not empty city}">value="${city}" </c:if>>
        <label for="city_select" class="">City</label>
    </div>

    <p>Input your mobile phone</p>
    <div class="md-form">
        <i class="fa fa-mobile-phone prefix"></i>
        <input type="text" name="phone" id="phone" class="form-control"
               <c:if test="${not empty phone}">value="${phone}" </c:if>>
        <label for="phone" class="">Your mobile phone</label><br/>
    </div>

    <%  int i = 0; %>
    <input type="hidden" name="id" value="<% i++;%>">

    <button type="submit" value="Register" name="submit" onclick="validate()" class="btn btn-primary btn-lg">Register
    </button>
</form>

<a href="<c:url value="/authentification"/>">Already have an account? Sign in</a>

<script src="webjars/jquery/1.9.1/jquery.js"></script>
<script src="webjars/jquery-validation/1.15.1/jquery.validate.js"></script>
<script src="<c:url value="/js/check.js"/>"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>

<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/tether.js"/>"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="<c:url value="/js/mdb.js"/>"></script>
<script>
    $('input[type="checkbox"]').on('change', function () {
        $('input[name="' + this.name + '"]').not(this).prop('checked', false);
    });
</script>
</body>
</html>
