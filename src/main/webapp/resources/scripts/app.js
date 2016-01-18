/**
 * Created by alexggg99 on 15.01.16.
 */


angular.module("ContactsApp", ['ngRoute', 'ngResource'])
    .config(function($routeProvider, $locationProvider){
        $routeProvider.when('/',{
            controller:'contactController',
            templateUrl: "resources/templates/contacts.html"
        })
            .when('/logout', {
                controller:'logoutController',
                templateUrl: "resources/templates/contacts.html"
            });

        $locationProvider.html5Mode(true);

    }).value('base', {
        backend: '/ContactsApp'
    });