/**
 * Created by mijo on 2015-07-15.
 */
app.controller('WebSocketController', ['$scope', '$websocket', 'ConnectionFactory', function ($scope, $websocket, ConnectionFactory) {

    $scope.ConnectionFactory = ConnectionFactory;

    $scope.submit = function () {
        ConnectionFactory.send('Here is another message from client submit.');
    }

    //$scope.username = 'anonymous';
    //$scope.Messages = Messages;
    //$scope.submit = function(new_message) {
    //    if (!new_message) { return; }
    //    Messages.send({
    //        username: $scope.username,
    //        message: new_message
    //    });
    //    $scope.new_message = '';
    //};

}]);