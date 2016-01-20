/**
 * Created by alexggg99 on 20.01.16.
 */

angular.module("ContactsApp")
    .controller('navBarController', function($scope, $rootScope, base, $location){

        $scope.baseUrl = base.backend;

        $rootScope.$on( "$routeChangeStart", function(event, next, current) {
            $scope.PAGE = $location.$$path;
        });

    })