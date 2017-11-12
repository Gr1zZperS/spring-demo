// var app = angular.module("springDemo", [])
var app = angular.module("springDemo", []);

app.controller("AppController", function($scope, $http) {

    $scope.companies = [];

    $http({method: 'GET', url: 'http://localhost:8099/api/companies'}).then(function(success) {
        $scope.companies = success.data;
    });
});