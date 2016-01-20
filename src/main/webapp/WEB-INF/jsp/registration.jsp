<%--
  Created by IntelliJ IDEA.
  User: alexggg99
  Date: 20.01.16
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Registration</title>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Login</title>
  <link href="resources/styles/signin.css" rel="stylesheet">
  <link href="resources/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
  <link href="resources/bower_components/bootswatch/flatly/bootstrap.css" rel="stylesheet">
</head>
<body>


<div class="container">
  <div class="row">

    <c:if test="${badCredentions} != null">
        There was an exception: ${myExceptionObject.message}
    </c:if>

    <form class="form-horizontal" action="<c:url value='/regUser' />" method="post">
      <fieldset>

        <!-- Form Name -->
        <legend><a href="<c:url value='/' />"> <span class="glyphicon glyphicon-chevron-left"></a>Регистрация</legend>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="fn">Username</label>
          <div class="col-md-4">
            <input id="fn" name="username" type="text"
                   placeholder="username" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="ln">Password</label>
          <div class="col-md-4">
            <input id="ln" name="password" type="text"
                   placeholder="password" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="submit"></label>
          <div class="col-md-4">
            <button id="submit" name="submit" class="btn btn-primary">SUBMIT</button>
          </div>
        </div>

      </fieldset>
    </form>


  </div>
</div>




</body>
</html>
