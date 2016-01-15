/**
 * Created by alexggg99 on 15.01.16.
 */


angular.module("ContactsApp", ['ngRoute'])
    .config(function($routeProvider, $locationProvider){
        $routeProvider.when('/list',{
            controller:'listController',
            templateUrl: "resources/templates/list.html",
        });

        $locationProvider.html5Mode(true);

    })