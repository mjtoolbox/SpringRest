/**
 * Created by mijo on 2015-06-23.
 */
app.controller('MessageController',['$scope','$http', function ($scope, $http) {
    $http.get('resources/data/messageEvents.json').success(function(data) {
        $scope.messageEvents = data;
    });

    //$scope.messageEvents = [
    //    {
    //        "id": "12345",
    //        "reservoir": "ALU",
    //        "message": "Instruction Pending - testing creating instruction",
    //        "time": "Sent At 10:10, Thu, 11 Jun 2015"
    //    },
    //    {
    //        "id": "12346",
    //        "reservoir": "JHT",
    //        "message": "Implementation Created - testing ",
    //        "time": "Created At 09:00, Fri, 12 Jun 2015"
    //    },
    //    {
    //        "id": "12347",
    //        "reservoir": "SFL",
    //        "message": "Instruction Pending - testing sending instruction",
    //        "time": "Sent At 10:10, Mon, 15 Jun 2015"
    //    },
    //    {
    //        "id": "12348",
    //        "reservoir": "CQD",
    //        "message": "Instruction Sent - Instruction was sent",
    //        "time": "Sent At 11:11, Tue, 16 Jun 2015"
    //    },
    //    {
    //        "id": "12349",
    //        "reservoir": "PCN",
    //        "message": "Instruction Pending - testing sending instruction",
    //        "time": "Sent At 12:10, Wed, 17 Jun 2015"
    //    }
    //]

}]);