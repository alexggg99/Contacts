/**
 * Created by alexggg99 on 21.01.16.
 */

angular.module("ContactsAppRegistration")
    .factory('registration', function($resource, base){
        return $resource(base.backend+'/regUser');
    })