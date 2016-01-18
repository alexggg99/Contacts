/**
 * Created by alexggg99 on 18.01.16.
 */
angular.module("ContactsApp")
    .factory('Contact', function($resource){
        return $resource('/contact/:id',{id:'@id'},{
            'update':{method:'PUT'}
        })
    })

