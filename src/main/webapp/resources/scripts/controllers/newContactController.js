/**
 * Created by alexggg99 on 15.01.16.
 */

angular.module("ContactsApp")
    .controller('newContactController', function($scope, Contact, $location){

        $scope.contact = new Contact({
            fullName : ['','text'],
            email: ['','email'],
            vkId : ['','url'],
            phone : ['','tel'],
            birthday : ['','date']
        });

        $scope.createContact = function(){
            if($scope.newContact.$invalid){
                $scope.$broadcast('record:invalid');
            }else{
                $scope.contact.save();
                $location.url('/');
            }
        }

    });