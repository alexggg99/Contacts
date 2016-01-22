/**
 * Created by alexggg99 on 18.01.16.
 */
angular.module("ContactsApp")
    .factory('Contact', function($resource, base){
        return $resource(base.backend + '/contact/:id',{id:'@id'},{
            'update':{method:'PUT'}
        })
    });

