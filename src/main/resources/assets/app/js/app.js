(function() {
    var app = angular.module('my_app', []);
    app.controller('MainController', ['$scope','$http', function($scope, $http) {
        $scope.investorName = '';
        $scope.getInvestor = function() {
            if($scope.investorName === ''){
                alert('Please insert an investor name');
                return;
            }
            $http({
                method: 'GET',
                url: '/api/investor/' + $scope.investorName
            }).then(
                function success(response) {
                    $scope.investorID = response.data.id;
                    if(response.data.address === null) {
                        $scope.investorAddress = 'Address not available!';
                    } else {
                        $scope.investorAddress = response.data.address;
                    }
                    $scope.investorSSN = response.data.ssn;
                },
                function failure(response) {
                    $scope.investorID = '';
                    $scope.investorAddress = '';
                    $scope.investorSSN = '';
                    alert('failed to get investor details!');
                }
            )
        };

        $scope.update = function() {
            var investor = {
                id: $scope.investorID,
                name: $scope.investorName,
                address: $scope.investorAddress,
                ssn: $scope.investorSSN
            };
            $http({
                method: 'POST',
                url: '/api/investor/update',
                data: investor
            }).then(function success(response) {
                alert('The investor data has been updated!');
            }, function failure(response) {
                alert('Was not able to update the investor!');
            });
        };

    }]);
})();