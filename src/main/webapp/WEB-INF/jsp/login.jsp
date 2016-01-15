<%--
  Created by IntelliJ IDEA.
  User: alexggg99
  Date: 24.12.15
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html>
<head>
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


  <h3 class="container">
      <form name='loginForm'
            action="<c:url value='/login' />" class="form-signin" method='POST'>
      <h2 class="form-signin-heading">Авторизуйтесь</h2>
          <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
              <div class="alert alert-danger" role="alert">
                  <span>
                      Проверте логин или пароль
                  </span>
              </div>
          </c:if>
      <label for="inputLogin" class="sr-only">Login</label>
      <input type="text" id="inputLogin" name="username" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
      <div class="checkbox">
        <label>
          <input type="checkbox" id="remember-me" name="remember-me"> Запомнить
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

  </div> <!-- /container -->


</body>
</html>