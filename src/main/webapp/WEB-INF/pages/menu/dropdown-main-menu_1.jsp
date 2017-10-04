<!--
 to-do: 2014/03/02 下拉式選單, 未完成(not finished)
 1.test customerList item - ok
 -->

<!doctype html>
<html ng-app="MenuApp1" ng-controller="AppController">
<head>
    <!-- Load libs. -->
    <!-- <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css" /> -->
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.css" />
    
    <!--<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.js"></script>-->
    <!-- <script src="../../resources/js/lib/angular/angular.js"></script> -->
    <script type="text/javascript" src="angjs/angular.min.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>    
    

    <!-- Load my script & css -->
    <!-- my stylecheet -->
    <!-- <link rel="stylesheet" href="../../resources/css/myBootstrap/bootstrap-MyStyle-Blue_1.0.css" /> -->
    <link rel="stylesheet" href="css/myBootstrap/bootstrap-MyStyle-Blue_1.0.css" />    
    <!--<link rel="stylesheet" href="../resources/css/myTheme/myGreenStyle_1.css" />-->
    <!-- <link rel="stylesheet" href="../../resources/css/myTheme/myBlueStyle_1.css" /> -->
    <link rel="stylesheet" href="css/myTheme/myBlueStyle_1.css" />
    <!-- my js -->
    <!-- <script src="../../resources/js/common/routes/routeApp_dropdown-toggle_1.js"></script> -->
    <script src="blueAppjs/common/routes/routeApp_dropdown-toggle_1.js"></script>
    <!--<script src="../../resources/js/common/routeApp_2-1.js"></script>-->
    <!-- <script src="../../resources/js/controllers/basic_data/CustomerController_2.js"></script> -->
    <script src="blueAppjs/controllers/basic_data/CustomerController_2.js"></script>


</head>
<body>

<!-- Main Menu Navbar -->
<div class="navbar navbar-fixed-top" ng-controller="DropdownMenuCtrl_1">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#/home" ng-class="{ on: isHome }">Sales/Order Template</a>
            <ul class="nav" >
                <li class="dropdown" >
                    <a class="dropdown-toggle">System Mgnt</a>
                    <ul class="dropdown-menu">
                        <li ng-repeat="choice in items1">
                            <a>{{choice}}</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown" >
                    <a class="dropdown-toggle">BasicData Maintance</a>
                    <ul class="dropdown-menu">
                        <li ng-repeat="choice in items2">
                            <a href="{{choice.hrefLink}}">{{choice.displayName}}</a>
                        </li>
                    </ul>
                </li>
                <!-- for test -->
                <li><a href="#/customerList" ng-class="{ on: isCustomerList }">CustomerList</a></li>
                <li><a href="#/salesInfo">Sales/Orders</a></li>
            </ul>
        </div>
    </div>
</div>

<hr/>
<p></p>

<div>
    <hr class="" />
    <!--<div ng-view></div>-->
    <!-- Content -->
    <div class="container">
        <div class="row">
            <div class="">

                <!-- Dynamic content -->
                <div ng-switch on=" renderPath[ 0 ]">

                    <!-- <div ng-switch-when="home" ng-include=" '../common/Home.html' "></div> -->
                    <div ng-switch-when="home" ng-include=" 'thtml/common/Home.html' "></div>
                    <!-- <div ng-switch-when="customerList" ng-include=" '../basic_data/CustomerLayout_2.html' "></div> -->
                    <div ng-switch-when="customerList" ng-include=" 'thtml/basic_data/CustomerLayout_2.html' ">
                    
                    <div ng-switch-when="customer" ng-include=" 'contact.htm' "></div>

                </div>

            </div>
        </div>
    </div>

</div>



</body>
</html>
