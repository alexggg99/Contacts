/**
 * Created by alexggg99 on 15.01.16.
 */

angular.module("ContactsApp")
    .controller('contactController', function($scope, $rootScope, Contact, $location, base, $routeParams){

        $scope.fields = ['id' ,'fullName', 'phone'];

        $rootScope.PAGE = 'all';

        $scope.sort = function(field){
            $scope.sort.field = field;
            $scope.sort.order = !$scope.sort.order;
        };

        $scope.sort.field = 'id';
        $scope.sort.order = false;

        $scope.show = function(id){
            $location.url('/editContact/' + id);
        }

        $scope.contacts = [];

        $scope.init = function(){
            $scope.contacts = Contact.query();
        }

        $scope.baseUrl = base.backend;

        $scope.contact = new Contact({
            fullName : '',
            email: '',
            vkId : '',
            phone : '',
            birthday : ''
        });

        $scope.createContact = function(){
            if($scope.newContact.$invalid){
                $scope.$broadcast('record:invalid');
            }else{
                $scope.contact = new Contact($scope.contact);
                $scope.contact.$save(function (contact) {
                    $scope.contacts.push(contact);
                });
                $location.path('/');
            }
        };

        $scope.cancel = function(){
            //$scope.contact = {};
            $location.path('/');
        };

        if($routeParams.id != null){
            $scope.contact = Contact.get({id: parseInt($routeParams.id, 10)});
        }

        $scope.delete = function(){
            $scope.contact.$delete(function(){
                var index = $scope.contacts.indexOf($scope.contact);
                $scope.contacts.splice(index, 1);
            });
            $location.url('/');
        }

        $scope.update = function(){
            $scope.contact = new Contact($scope.contact);
            $scope.contact.$update();
            $location.url('/');
        }

    })