/**
 * Created by Charlotte_Admin on 2014/3/1.
 * for dropdown_toggle_t1.html
 */

//angular.module('MenuApp1', ['ui.bootstrap']);
var MenuApp1 = angular.module( 'MenuApp1', ['ui.bootstrap'] );

// Configure the routing. The $routeProvider will be
// automatically injected into the configurator.
MenuApp1.config(
    function( $routeProvider ){

        // Typically, when defining routes, you will map the
        // routes to a Template to be rendered; however, this
        // only makes sense for simple web sites. When you
        // are building more complex applications, with
        // nested navigation, you probably need something more
        // complex. In this case, we are mapping routes to
        // render "Actions" rather than a template.
        $routeProvider
            .when(
            "/home",
            {
                action: "home.default"
            }
        )
            .when(
            "/customerList",
            {
                action: "customerList.list"
            }
        )
            .when(
            "/customer/:username",
            {
                action: "customer.form"
            }
        )
            .otherwise(
            {
                redirectTo: "/home"
            }
        )
        ;

    }
);


// -------------------------------------------------- //
// -------------------------------------------------- //


// Define our root-level controller for the application.
MenuApp1.controller(
    "AppController",
    function( $scope, $route, $routeParams ){

        // Update the rendering of the page.
        render = function(){

            // Pull the "action" value out of the
            // currently selected routes.
            var renderAction = $route.current.action;

            // Also, let's update the render path so that
            // we can start conditionally rendering parts
            // of the page.
            var renderPath = renderAction.split( "." );

            // Grab the username out of the params.
            //
            // NOTE: This will be undefined for every routes
            // except for the "customer" routes; for the sake
            // of simplicity, I am not exerting any finer
            // logic around it.
            var username = ($routeParams.username || "");

            // Reset the booleans used to set the class
            // for the navigation.
            var isHome = (renderPath[ 0 ] == "home");
            var isCustomerList = (renderPath[ 0 ] == "customerList");
            var isCustomer = (renderPath[ 0 ] == "customer");

            // Store the values in the model.
            $scope.renderAction = renderAction;
            $scope.renderPath = renderPath;
            $scope.username = username;
            $scope.isHome = isHome;
            $scope.isCustomerList = isCustomerList;
            $scope.isCustomer = isCustomer;

        };

        // Listen for changes to the Route. When the routes
        // changes, let's set the renderAction model value so
        // that it can render in the Strong element.
        $scope.$on(
            "$routeChangeSuccess",
            function( $currentRoute, $previousRoute ){

                // Update the rendering.
                render();

            }
        );

    }
);

// function DropdownMenuCtrl_1($scope) {
MenuApp1.controller("DropdownMenuCtrl_1",
                    ['$scope', function( $scope ){

    $scope.items1 = [
        "The first choice!",
        "And another choice for you.",
        "but wait! A third!"
    ];

    $scope.items2 = [
        {"hrefLink":"#/companyInfo","displayName":"Company Info"},
        {"hrefLink":"#/customerList","displayName":"CustomerList"},
        {"hrefLink":"#/customer/aaa","displayName":"A Customer Data"}
    ];


}]);