/**
 * Created by mijo on 2015-06-23.
 */
app.controller('MessageController',['$scope','$http', function ($scope, $http) {
    $http.get('resources/data/messageEvents.json').success(function(data) {
        $scope.messageEvents = data;
    });


}]);