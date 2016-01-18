<%--
  Created by IntelliJ IDEA.
  User: alexggg99
  Date: 15.01.16
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="ContactsApp">
<head>
    <title>Contacts</title>

    <link href="<c:url value='/resources/styles/main.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/bower_components/bootstrap/dist/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/bower_components/bootswatch/flatly/bootstrap.css' />" rel="stylesheet">

    <base href="/ContactsApp/">
</head>
<body>
    <div class="container">
        <div class="row">
            <h1>Contacts</h1>
            <div class="col-sm-12" data-ng-view>
            </div>
        </div>
    </div>

  <script src="<c:url value='/resources/bower_components/angular/angular.js' />"></script>
  <script src="<c:url value='/resources/bower_components/angular-resource/angular-resource.js' />"></script>
  <script src="<c:url value='/resources/bower_components/angular-route/angular-route.js' />"></script>
  <script src="<c:url value='/resources/bower_components/jquery/dist/jquery.js' />"></script>
  <script src="<c:url value='/resources/bower_components/bootstrap/dist/js/bootstrap.js' />"></script>

  <script src="<c:url value='/resources/scripts/app.js' />"></script>
    <script src="<c:url value='/resources/scripts/controllers/contactController.js' />"></script>
    <script src="<c:url value='/resources/scripts/services/contact.js' />"></script>

</body>
</html>
