/**
 * Created by alexggg99 on 15.01.16.
 */

angular.module("ContactsApp")
    .controller('newContactController', function($scope, Contact, $location){

        //$scope.contact = new Contact({
        //    fullName : '',
        //    email: '',
        //    vkId : '',
        //    phone : '',
        //    birthday : ''
        //});

        $scope.contact = {};

        $scope.createContact = function(){
            if($scope.newContact.$invalid){
                $scope.$broadcast('record:invalid');
            }else{
                $scope.contact = new Contact($scope.contact);
                $scope.contact.$save();
                $location.url('/');
            }
        };

        $scope.cancel = function(){
            //$scope.contact = {};
            $location.href('/');
        }

    });