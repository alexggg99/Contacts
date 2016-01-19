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

    <link href="<c:url value='/resources/styles/main.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/bower_components/bootstrap/dist/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/bower_components/bootswatch/flatly/bootstrap.css' />" rel="stylesheet">

    <base href="/ContactsApp/">

</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h2><a href="<c:url value='/' />">Contacts</a></h2>
            </div>
            <div class="col-sm-6">
                <h2 class="pull-right">
                    <a href="<c:url value='/logout' />">Logout</a>
                </h2>
            </div>
            <div class="col-sm-12 blank"></div>
            <div class="col-sm-12" data-ng-view>
            </div>
        </div>
    </div>

  <script src="<c:url value='/resources/bower_components/angular/angular.js' />"></script>
  <script src="<c:url value='/resources/bower_components/angular-resource/angular-resource.js' />"></script>
  <script src="<c:url value='/resources/bower_components/angular-route/angular-route.js' />"></script>
  <script src="<c:url value='/resources/bower_components/jquery/dist/jquery.js' />"></script>
  <script src="<c:url value='/resources/bower_components/bootstrap/dist/js/bootstrap.js' />"></script>
    <script src="<c:url value='/resources/bower_components/angular-messages/angular-messages.js' />"></script>
  <script src="<c:url value='/resources/scripts/app.js' />"></script>
    <script src="<c:url value='/resources/scripts/controllers/contactController.js' />"></script>
    <script src="<c:url value='/resources/scripts/controllers/logoutController.js' />"></script>
    <script src="<c:url value='/resources/scripts/controllers/newContactController.js' />"></script>
    <script src="<c:url value='/resources/scripts/services/contact.js' />"></script>
    <script src="<c:url value='/resources/scripts/services/filter.js' />"></script>
    <script src="<c:url value='/resources/scripts/directives/directive.js' />"></script>

</body>
</html>
