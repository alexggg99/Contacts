/**
 * Created by alexggg99 on 21.01.16.
 */

angular.module("ContactsApp")
    .controller('settingsController', function($scope, $rootScope, options, Fields){
        $scope.fields = options.dispalyed_fields;
        $scope.allFields = Fields.headers();
        //Fields.headers().then(function(data){
        //    console.log(data);
        //    $scope.allFields = data;
        //});

        //$scope.init = function(){
        //    $scope.allFields = Fields.headers();
        //}

        $scope.toggle = function(field){
            if(field == "fullName" || field == "vk"){
                //required fields
                return;
            }
            var i = options.dispalyed_fields.indexOf(field);
            if(i > -1){
                //unchecking the field
                options.dispalyed_fields.splice(i,1);
            }else{
                //checking the field
                options.dispalyed_fields.push(field);
            }
            Fields.set(options.dispalyed_fields);
        }

    })