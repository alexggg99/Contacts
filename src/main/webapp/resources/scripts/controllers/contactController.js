/**
 * Created by alexggg99 on 15.01.16.
 */

angular.module("ContactsApp")
    .controller('contactController', function($scope, Contact){
        $scope.contacts = Contact.query();
        $scope.fields = ['id' ,'fullName', 'phone'];

        $scope.sort = function(field){
            $scope.sort.field = field;
            $scope.sort.order = !$scope.sort.order;
        };

        $scope.sort.field = 'id';
        $scope.sort.order = false;



    })