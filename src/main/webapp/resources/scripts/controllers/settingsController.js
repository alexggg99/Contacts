/**
 * Created by alexggg99 on 21.01.16.
 */

angular.module("ContactsApp")
    .controller('settingsController', function($scope, $rootScope, options, Fields){
          $scope.allFields = [];
        $scope.fields = options.dispalyed_fields;

        //Fields.headers().then(function(data){
        //    console.log(data);
        //    $scope.allFields = data;
        //});
        $scope.allFields = Fields.headers();
    })