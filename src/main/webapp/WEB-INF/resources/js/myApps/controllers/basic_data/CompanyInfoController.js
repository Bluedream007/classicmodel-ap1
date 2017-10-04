'use strict';

/**
 * CompanyInfoController
 * @constructor
 */
var CompanyInfoController = function($scope, $http) {
    $scope.fetchEmployeeList = function() {
        // to do - change code - get from REST web service
        $http.get('cars/carlist.json').success(function(carList){
            $scope.cars = carList;
        });
    }

    // todo - change the uri by Spring mvc controller
    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCompanyList();
        });
        $scope.carName = '';
    }

    // todo - change the uri by Spring mvc controller
    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    }

    // todo - change the uri by Spring mvc controller
    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };

    $scope.fetchCarsList();
}