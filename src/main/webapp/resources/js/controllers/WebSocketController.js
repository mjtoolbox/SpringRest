/**
 * Created by mijo on 2015-07-15.
 */
app.controller('WebSocketController', ['$scope', '$websocket', function ($scope, $websocket, Messages) {

    // Calling Service to retrieve JSON
    //$http.get('spring/service/messages').success(function (data) {
    //    $scope.messageEvents = data;
    //});

    $scope.username = 'anonymous';

    $scope.Messages = Messages;

    $scope.submit = function(new_message) {
        if (!new_message) { return; }
        Messages.send({
            username: $scope.username,
            message: new_message
        });
        $scope.new_message = '';
    };

}]);