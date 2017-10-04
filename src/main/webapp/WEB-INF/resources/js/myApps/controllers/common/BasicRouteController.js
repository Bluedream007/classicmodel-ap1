/**
 * Created by Charlotte_Admin on 2014/2/28.
 */
// 'use strict';

/**
 * CustomerController
 * @constructor
 */
var BasicRouteController = function($scope, $http, $rootScope, $routeParams) {
    // Getting the slug from $routeParams
    var slug = $routeParams.slug;

    //$scope.$emit('routeLoaded', {slug: slug});
    // $scope.$broadcast('routeLoaded', {slug: slug});


    angular.element(document.getElementById('CustomerController_3')).scope();

    // Set the slug for menu active class
    //$scope.$on('routeLoaded', function (event, args) {
    //    $scope.slug = args.slug;
    //});
}
