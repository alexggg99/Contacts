/**
 * Created by alexggg99 on 18.01.16.
 */
angular.module("ContactsApp")
    .factory('Contact', function($resource, base){
        return $resource(base.backend + '/contact/:id',{id:'@id'},{
            'update':{method:'PUT'}
        })
    })
    .factory('Fields', function($q, $http, Contact, base){
        //return $resource(base.backend + '/contact/getOptions')
        var url = base.backend+'/settings',
            ignore = ['fullName', 'id' ],
            allFields = [],
            deferred = $q.defer(),
            contacts = Contact.query(function(){
                contacts.forEach(function(c){
                    Object.key(c).forEach(function(k){
                        if(allFields.indexOf(k) < 0 && ignore.indexOf(k) < 0){
                            allFields.push(k);
                        }
                    });
                });
                deferred.resolve(allFields);
            });
        return {
            get: function(){
                return $http.get(url);
            },
            set: function(newFields){
                return $http.post(url, { fields : newFields });
            },
            headers: function(){
                return deferred.promise;
            }
        }
    });

