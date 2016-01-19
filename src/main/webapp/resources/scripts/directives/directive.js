/**
 * Created by alexggg99 on 18.01.16.
 */

angular.module("ContactsApp")
    .value('FieldTypes', {
        text : ['Text', 'should be a text'],
        url : ['URL', 'should be a URL'],
        date : ['Date', 'should be a date'],
        tel : ['Phone', 'should be phone a number'],
        email: ['Email','should be a email']
    })
    .directive('formField', function($timeout, FieldTypes){
        return {
          restrict:'EA',
          templateUrl :'resources/templates/form-field.html',
          replace : true,
          scope:{
              record : '=',
              field : '@',
              live : '@',
              required : '@',
              type: '@'
          },
            link : function($scope, element, attr){
                $scope.$on('record:invalid', function(){
                    $scope[$scope.field].$setDirty();
                });
                $scope.types = FieldTypes;
                $scope.remove = function(field){
                    delete $scope.record[field];
                    //$scope.blureUpdate();
                };
                //$scope.blurUpdate = function(){
                //    if($scope.live !== 'false'){
                //        $scope.record.$update(function(updatedRecord){
                //            $scope.record = updatedRecord;
                //        })
                //    }
                //};
                //var saveTimeout;
                //$scope.update = function(){
                //    $timeout.cancel(saveTimeout);
                //    saveTimeout = $timeout($scope.blureUpdate, 1200);
                //};
            }
        };
    })
    .directive('newField', function($filter, FieldTypes){
        return {
            restrict:'EA',
            templateUrl :'resources/templates/new-field.html',
            replace : true,
            scope:{
                record : '=',
                live : '@'
            },
            required:'^form',
            link:function($scope, element, attr, form){
                $scope.types = FieldTypes;
                $scope.field = {};
                $scope.show = function(type){
                    $scope.field.type = type;
                    $scope.display = true;
                };
                $scope.remove = function(){
                    $scope.field.type = {};
                    $scope.display = false;
                };
                $scope.add = function(){
                    if(form.newField.$valid){
                        $scope.record[$scope.field.name] = $scope.field.value;
                        $scope.remove();
                    }
                };
            }
        }
    })