<%--
  Created by IntelliJ IDEA.
  User: alexggg99
  Date: 20.01.16
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>


<html ng-app="ContactsAppRegistration">
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

  <style>
    [ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],ng-cloak,x-ng-cloak
    {
      display:none !important;
    }

  </style>

  <base href="/ContactsApp/">
</head>
<body>


<div class="container" ng-controller="registrationController">
  <div class="row">

    <form name="registrationForm" class="form-horizontal" method="post" novalidate>
      <fieldset>

        <!-- Form Name -->
        <legend><a href="<c:url value='/' />"> <span class="glyphicon glyphicon-chevron-left"></a>Регистрация</legend>

        <div class="form-group" ng-if="error.flag == 'exist'" ng-cloak>
          <div class="col-md-offset-4 col-md-4 ">
            <div class="alert alert-danger fade in">
              <a href="#" class="close" data-dismiss="alert">&times;</a>
              <strong>Error!</strong> {{error.text}} !
            </div>
          </div>
        </div>

        <div class="form-group" ng-if="error.flag == 'success'" ng-cloak>
          <div class="col-md-offset-4 col-md-4 ">
            <div class="alert alert-success fade in">
              <a href="#" class="close" data-dismiss="alert">&times;</a>
              <strong>Success!</strong> The user has been successfully created.
            </div>
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group" ng-class="{'has-error' : registrationForm.username.$dirty && registrationForm.username.$invalid }">
          <label class="col-md-4 control-label" for="fn">Username</label>
          <div class="col-md-4">
            <input id="fn" name="username" ng-model="user.username" type="text" ng-maxlength="15" ng-minlength="4"
                   placeholder="username" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group" ng-class="{'has-error' : registrationForm.password.$dirty && registrationForm.password.$invalid }">
          <label class="col-md-4 control-label" for="ln">Password</label>
          <div class="col-md-4">
            <input id="ln" name="password" ng-model="user.password" type="text" ng-maxlength="15" ng-minlength="3"
                   placeholder="password" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="submit"></label>
          <div class="col-md-4">
            <button ng-disabled="!registrationForm.$valid" id="submit" ng-click="submit()" name="submit" class="btn btn-primary">SUBMIT</button>
          </div>
        </div>

      </fieldset>
    </form>


  </div>
</div>


<script src="<c:url value='/resources/bower_components/angular/angular.js' />"></script>
<script src="<c:url value='/resources/bower_components/angular-resource/angular-resource.js' />"></script>
<script src="<c:url value='/resources/bower_components/angular-route/angular-route.js' />"></script>
<script src="<c:url value='/resources/bower_components/jquery/dist/jquery.js' />"></script>
<script src="<c:url value='/resources/bower_components/bootstrap/dist/js/bootstrap.js' />"></script>
<script src="<c:url value='/resources/bower_components/angular-messages/angular-messages.js' />"></script>
<script src="<c:url value='/resources/scripts/controllers/registrationController.js' />"></script>
<script src="<c:url value='/resources/scripts/services/auth.js' />"></script>

</body>
</html>
