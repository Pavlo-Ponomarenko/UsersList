<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
<head>
    <title>Log in</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/NewProfile.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Users List</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div style="width: 500px; display: table; margin: auto; margin-top: 100px;">
    <form  action="${pageContext.request.contextPath}/add_profile" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input class="form-control" id="login" name="login" aria-describedby="emailHelp" placeholder="Enter login">
            <small id="loginErr" class="form-text text-muted"> </small>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailErr" class="form-text text-muted"> </small>
        </div>
        <div class="form-group">
            <label for="age">Age</label>
            <input class="form-control" id="age" name="age" aria-describedby="emailHelp" placeholder="Enter age">
            <small id="ageErr" class="form-text text-muted"> </small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
            <small id="passwordErr" class="form-text text-muted"> </small>
        </div>
        <button type="button" class="btn btn-primary" onclick="createProfile();">Create profile</button>
    </form>
</div>
</body>
</html>
