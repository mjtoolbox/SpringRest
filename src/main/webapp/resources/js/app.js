var app = angular.module("myApp",['angular-websocket']);
    app.factory('ConnectionFactory', function ($websocket) {
        var wsURI = 'ws://' + window.location.host + '/springrest/websocket/myService';
        var websocket = $websocket(wsURI);

        var collection = [];

        websocket.onMessage(function (event) {
            console.log('message: ' + event.data);
            var response = angular.fromJson(event.data);

            for (var i = 0; i < response.length; i++) {
                collection.push({
                    oid: response[i].oid,
                    id: response[i].id,
                    reservoir: response[i].reservoir,
                    title: response[i].title,
                    description: response[i].description,
                    triggerTime: response[i].triggerTime,
                    submitTime: response[i].submitTime,
                    submitBy: response[i].submitBy,
                    status: response[i].status
                });
            }
        });

        websocket.onOpen(function (event) {
            console.log('Connection open!');
            websocket.send('HELLO Server!');
        });

        websocket.onError(function (event) {
            console.log('Error occurred : ' + event);
        });

        websocket.onClose = function () {
            console.log('Connection was closed or timed out');
        };


        return {
            collection: collection,
            status: function () {
                return websocket.readyState;
            },
            send: function (message) {
                if (angular.isString(message)) {
                    websocket.send(message);
                }
                else if (angular.isObject(message)) {
                    websocket.send(JSON.stringify(message));
                }
            }
        };
    });


