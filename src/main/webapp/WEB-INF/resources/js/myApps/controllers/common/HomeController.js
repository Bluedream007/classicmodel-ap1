'use strict';

/**
 * HomeController
 * @constructor
 */
var HomeController = function($scope, $http) {
    $scope.customer = {};
    $scope.editMode = false;

    $scope.fetchCustomerData = function() {
       /*
        $http.get('trains/trainslist.json').success(function(trainList){
            $scope.trains = trainList;
        });
        */

        $scope.customer=
            {"state":null,"country":"France","phone":"40.32.2555","city":"Nantes","postalCode":"44000","customerNumber":103,"customerName":"Atelier graphique","contactLastName":"Schmitt","contactFirstName":"Carine ","addressLine1":"54, rue Royale","addressLine2":null,"creditLimit":21000};
    }

    $scope.fetchCustomerData();

}