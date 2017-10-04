'use strict';

/**
 * CustomerController_1
 * @constructor
 */
var CustomerController_1 = function($scope, $http) {
    $scope.customer = {};
    $scope.editMode = false;



    $scope.fetchCustomerList = function() {
       /*
        $http.get('trains/trainslist.json').success(function(trainList){
            $scope.trains = trainList;
        });
        */

    $scope.CustomerList=
            [{"state":null,"country":"France","phone":"40.32.2555","city":"Nantes","postalCode":"44000","customerNumber":103,"customerName":"Atelier graphique","contactLastName":"Schmitt","contactFirstName":"Carine ","addressLine1":"54, rue Royale","addressLine2":null,"creditLimit":21000},
                {"state":"NV","country":"USA","phone":"7025551838","city":"Las Vegas","postalCode":"83030","customerNumber":112,"customerName":"Signal Gift Stores","contactLastName":"King","contactFirstName":"Jean","addressLine1":"8489 Strong St.","addressLine2":null,"creditLimit":71800},
                {"state":"Victoria","country":"Australia","phone":"03 9520 4555","city":"Melbourne","postalCode":"3004","customerNumber":114,"customerName":"Australian Collectors, Co.","contactLastName":"Ferguson","contactFirstName":"Peter","addressLine1":"636 St Kilda Road","addressLine2":"Level 3","creditLimit":117300},
                {"state":null,"country":"France","phone":"40.67.8555","city":"Nantes","postalCode":"44000","customerNumber":119,"customerName":"La Rochelle Gifts","contactLastName":"Labrune","contactFirstName":"Janine ","addressLine1":"67, rue des Cinquante Otages","addressLine2":null,"creditLimit":118200},
                {"state":null,"country":"Norway","phone":"07-98 9555","city":"Stavern","postalCode":"4110","customerNumber":121,"customerName":"Baane Mini Imports","contactLastName":"Bergulfsen","contactFirstName":"Jonas ","addressLine1":"Erling Skakkes gate 78","addressLine2":null,"creditLimit":81700},
                {"state":"CA","country":"USA","phone":"4155551450","city":"San Rafael","postalCode":"97562","customerNumber":124,"customerName":"Mini Gifts Distributors Ltd.","contactLastName":"Nelson","contactFirstName":"Susan","addressLine1":"5677 Strong St.","addressLine2":null,"creditLimit":210500},
                {"state":null,"country":"Poland","phone":"(26) 642-7555","city":"Warszawa","postalCode":"01-012","customerNumber":125,"customerName":"Havel & Zbyszek Co","contactLastName":"Piestrzeniewicz","contactFirstName":"Zbyszek ","addressLine1":"ul. Filtrowa 68","addressLine2":null,"creditLimit":0},
                {"state":null,"country":"Germany","phone":"+49 69 66 90 2555","city":"Frankfurt","postalCode":"60528","customerNumber":128,"customerName":"Blauer See Auto, Co.","contactLastName":"Keitel","contactFirstName":"Roland","addressLine1":"Lyonerstr. 34","addressLine2":null,"creditLimit":59700},
                {"state":"CA","country":"USA","phone":"6505555787","city":"San Francisco","postalCode":"94217","customerNumber":129,"customerName":"Mini Wheels Co.","contactLastName":"Murphy","contactFirstName":"Julie","addressLine1":"5557 North Pendale Street","addressLine2":null,"creditLimit":64600},
                {"state":"NY","country":"USA","phone":"2125557818","city":"NYC","postalCode":"10022","customerNumber":131,"customerName":"Land of Toys Inc.","contactLastName":"Lee","contactFirstName":"Kwai","addressLine1":"897 Long Airport Avenue","addressLine2":null,"creditLimit":114900},
                {"state":null,"country":"Spain","phone":"(91) 555 94 44","city":"Madrid","postalCode":"28034","customerNumber":141,"customerName":"Euro+ Shopping Channel","contactLastName":"Freyre","contactFirstName":"Diego ","addressLine1":"C/ Moralzarzal, 86","addressLine2":null,"creditLimit":227600},
                {"state":null,"country":"Sweden","phone":"0921-12 3555","city":"Lulea","postalCode":"S-958 22","customerNumber":144,"customerName":"Volvo Model Replicas, Co","contactLastName":"Berglund","contactFirstName":"Christina ","addressLine1":"Berguvsvagen  8","addressLine2":null,"creditLimit":53100},
                {"state":null,"country":"Denmark","phone":"31 12 3555","city":"Kobenhavn","postalCode":"1734","customerNumber":145,"customerName":"Danish Wholesale Imports","contactLastName":"Petersen","contactFirstName":"Jytte ","addressLine1":"Vinbaltet 34","addressLine2":null,"creditLimit":83400},
                {"state":null,"country":"France","phone":"78.32.5555","city":"Lyon","postalCode":"69004","customerNumber":146,"customerName":"Saveley & Henriot, Co.","contactLastName":"Saveley","contactFirstName":"Mary ","addressLine1":"2, rue du Commerce","addressLine2":null,"creditLimit":123900},
                {"state":null,"country":"Singapore","phone":"+65 221 7555","city":"Singapore","postalCode":"079903","customerNumber":148,"customerName":"Dragon Souveniers, Ltd.","contactLastName":"Natividad","contactFirstName":"Eric","addressLine1":"Bronz Sok.","addressLine2":"Bronz Apt. 3/6 Tesvikiye","creditLimit":103800},
                {"state":"NY","country":"USA","phone":"2125557413","city":"NYC","postalCode":"10022","customerNumber":151,"customerName":"Muscle Machine Inc","contactLastName":"Young","contactFirstName":"Jeff","addressLine1":"4092 Furth Circle","addressLine2":"Suite 400","creditLimit":138500},
                {"state":"PA","country":"USA","phone":"2155551555","city":"Allentown","postalCode":"70267","customerNumber":157,"customerName":"Diecast Classics Inc.","contactLastName":"Leong","contactFirstName":"Kelvin","addressLine1":"7586 Pompton St.","addressLine2":null,"creditLimit":100600}];
    }


    $scope.addNewCustomer = function(pCustomer) {
        $scope.resetError();

        // todo - change the uri by Spring mvc controller
        $http.post('custCRUD/addCustomer', pCustomer).success(function() {
            $scope.fetchCustomerList();
            $scope.customer.customerNumber = '';
            $scope.customer.customerName = '';
            $scope.customer.creditLimit = '';
            //$scope.train.diesel = false;
            $scope.setError('Append a new customer is successful!');
        }).error(function() {
            $scope.setError('Could not add a new customer');
        });
    }

    $scope.updateCustomer = function(pCustomer) {
        $scope.resetError();

        // todo - change the uri by Spring mvc controller
        $http.put('trains/updateCustomer', pCustomer).success(function() {
            $scope.fetchCustomerList();
            $scope.customer.customerNumber = '';
            $scope.customer.customerName = '';
            $scope.customer.creditLimit = '';
            // $scope.train.diesel = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the customer');
        });
    }

    $scope.editCustomer = function(pCustomer) {
        $scope.resetError();
        $scope.customer = pCustomer;
        $scope.editMode = true;
    }

    $scope.removeCustomer = function(pCustNumber) {
        $scope.resetError();

        // todo - change the uri by Spring mvc controller
        $http.delete('trains/removeTrain/' + pCustNumber).success(function() {
            $scope.fetchCustomerList();
        }).error(function() {
            $scope.setError('Could not remove customer');
        });
    }

    $scope.removeAllCustomers = function() {
        $scope.resetError();

        // todo - change the uri by Spring mvc controller
        $http.delete('trains/removeAllTrains').success(function() {
            $scope.fetchCustomerList();
        }).error(function() {
            $scope.setError('Could not remove all basic_data');
        });

    };

    $scope.resetCustForm = function() {
        $scope.resetError();
        $scope.customer = {};
        $scope.editMode = false;
    }

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchCustomerList();

    $scope.predicate = 'customerName';


}