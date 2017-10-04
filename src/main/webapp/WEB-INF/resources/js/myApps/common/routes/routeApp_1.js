'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {


    $routeProvider.when('/home', {
        templateUrl: 'common/Home.html',
        controller: HomeController
    });

        $routeProvider.when('/companyInfo', {
            templateUrl: 'companyInfo/layout',
            controller: CompanyInfoController
        });

    $routeProvider.when('/customers', {
        templateUrl: 'basic_data/CustomerLayout.html',
        controller: CustomerController_1
    });
    // templateUrl: 'basic_data/CustomerLayout.html',
    // controller: CustomerController
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    // $routeProvider.otherwise({redirectTo: '/cars'});
    $routeProvider.otherwise({redirectTo: '/customers'});
}]);
