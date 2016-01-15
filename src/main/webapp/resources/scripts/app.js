/**
 * Created by alexggg99 on 15.01.16.
 */


angular.module("ContactsApp", ['ngRoute'])
    .config(function($routeProvider, $locationProvider){
        $routeProvider.when('/contact',{
            controller:'listController',
            templateUrl: "resources/templates/contacts.html",
        });

        $locationProvider.html5Mode(true);

    })