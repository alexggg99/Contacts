/**
 * Created by alexggg99 on 15.01.16.
 */

angular.module("ContactsAppRegistration", ['ngResource'])
    .value('base', {
        backend: '/ContactsApp'
    })
    .controller('registrationController', function($scope, registration){

        $scope.user = {};
        $scope.error = {};

        $scope.submit = function(){
            var resource = new registration($scope.user);
            resource.$save(function(res){
                if(res.error == "exist"){
                    $scope.error.flag = "exist";
                    $scope.error.text = res.mes;
                }
                if(res.error == "success"){
                    $scope.error.flag = "success";
                    $scope.error.text = res.error;
                }
            });
            //$scope.user = new registration($scope.user);
            //$scope.user.$save();
        };

    })