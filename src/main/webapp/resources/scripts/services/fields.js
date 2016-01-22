/**
 * Created by alexggg99 on 22.01.16.
 */

angular.module("ContactsApp")
    .factory('Fields', function($q, $http, Contact, base, $resource){
        //return $resource(base.backend + '/settings')
        var url = base.backend+'/settings.json',
            ignore = ['id'],
            allFields = [],
            deferred = $q.defer();
        //contacts = Contact.query(function(){
        //    contacts.forEach(function(c){
        //        Object.key(c).forEach(function(k){
        //            if(allFields.indexOf(k) < 0 && ignore.indexOf(k) < 0){
        //                allFields.push(k);
        //            }
        //        });
        //    });
        //    deferred.resolve(allFields);
        //    console.log(contacts);
        //});
        var resource = $resource(url);
        var fields = resource.query(function(){
            fields.forEach(function(f){
                    if(ignore.indexOf(f) < 0){
                        allFields.push(f);
                    }
            })
        });
        return {
            get: function(){
                return $http.get(url+'/getUserSettings');
            },
            set: function(newFields){
                return $http.post(url, newFields);
            },
            headers: function(){
                //return deferred.promise;
                return allFields;
            }
        }
    });