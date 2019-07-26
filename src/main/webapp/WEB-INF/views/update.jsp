<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>
<body class="container">
<h3>Enter the User Details</h3>
<form:form method="POST" action="/updateUser" id="target" modelAttribute="user">
    <form:hidden id="id" path="Id"/>
<div class="form-group">
    <form:label path="FirstName">First name:</form:label>
    <form:input path="FirstName" class="form-control"/>

</div>
<div class="form-group">
    <form:label path="LastName">Last name:</form:label>
    <form:input path="LastName" class="form-control"/>
</div>
<div class="form-group">
    <form:label path="Address">Address:</form:label>
    <form:input path="Address" class="form-control"/>
</div>
<button type="submit" id="btnsubmit" class="btn btn-primary">Submit</button>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
