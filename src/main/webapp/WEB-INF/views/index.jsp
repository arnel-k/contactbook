<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
    <title>User Data</title>
</head>
<body>
<!--<div id="myalert" class="alert alert-warning alert-dismissible fade show text-center" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
     <strong>Nema zapisa u bazi!</strong>
</div>
<div id="successAlert" class="alert alert-success text-center collapse ">
    <a href="#" class="close" data-dismiss="alert">&times;</a>
    <strong>Zapis je dodan u bazu!</strong>
</div>-->

    <div class="container">
    <h3>User Data</h3>
    <c:set var="counter" value="1" scope="page" />

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>R.Br.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Akcija</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">

            <tr>
                <td>${counter}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getAddress()}</td>

                <td>
                    <a href="/delete/${user.getId()}">Delete</a> |
                    <a href="/update/${user.getId()}">Update</a>
                </td>

            </tr>
            <c:set var="counter" value="${counter+1}" scope="page" />
        </c:forEach>
        </tbody>
    </table>
    <a href="/user" id="link" class="btn btn-primary"  data-dismiss="alert">Add New User</a>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       <!-- <script type="text/javascript">

            var alertVal = ;
            var alertValS = ;
            if(alertVal == false){
                $("#myalert").remove();
            }

            $(document).ready(function(){
                console.log(alertVal+"--"+alertValS);
                if(alertValS == false){
                    $("#successAlert").show();

                }
                $("#link").click(function(){
                    alertVal = true;
                });
            });



        </script>-->
    </div>
</body>
</html>
