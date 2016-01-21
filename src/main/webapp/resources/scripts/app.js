/**
 * Created by alexggg99 on 15.01.16.
 */


angular.module("ContactsApp", ['ngRoute', 'ngResource', 'ngMessages'])
    .config(function($routeProvider, $locationProvider){
        $routeProvider.when('/',{
            controller:'contactController',
            templateUrl: "resources/templates/contacts.html"
        })
            .when('/logout', {
                controller:'logoutController',
                templateUrl: "resources/templates/contacts.html"
            })
            .when('/newContact', {
                controller:'contactController',
                templateUrl: "resources/templates/newContact.html"
            })
            .when('/editContact/:id', {
                controller:'contactController',
                templateUrl: "resources/templates/editContact.html"
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);

    }).value('base', {
        backend: '/ContactsApp'
    });