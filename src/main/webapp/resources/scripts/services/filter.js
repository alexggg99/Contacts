/**
 * Created by alexggg99 on 18.01.16.
 */
angular.module("ContactsApp")
    .filter('labelCase', function(){
        return function(input){
            input = input.replace(/([A-Z])/g , " $1");
            return input[0].toUpperCase() + input.slice(1);
        }
    })
    .filter('keyFilter',function(){
        return function(object, query){
            var result = {};
            angular.forEach(object, function(val, key){
                if(key !== query){
                    result[key] = val;
                }
            });
            return result;
        }
    })
    .filter('camelCase', function(){
        return function (input) {
            return input.toLowerCase().replace(/(\w\S*)/g, function(txt){
                return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
            })
        }
    })