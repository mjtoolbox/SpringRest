var app = angular.module("myApp",['ngWebsocket'])
    .factory('MyData', function($websocket) {
        // Open a WebSocket connection
        var ws = $websocket('ws://localhost/springrest/websocket/helloName');
        var collection = [];

        ws.onMessage(function(event) {
            collection.push(JSON.parse(event.data));
            console.log('message: ', event);
            //var res;
            //try {
            //    res = JSON.parse(event.data);
            //} catch(e) {
            //    res = {'username': 'anonymous', 'message': event.data};
            //}
            //
            //collection.push({
            //    username: res.username,
            //    content: res.message,
            //    timeStamp: event.timeStamp
            //});
        });

        ws.onError(function(event) {
            console.log('connection Error', event);
        });

        ws.onClose(function(event) {
            console.log('connection closed', event);
        });

        ws.onOpen(function() {
            console.log('connection open');
            ws.send('Hello World');
            ws.send('again');
            ws.send('and again');
        });


        //return {
        //    collection: collection,
        //    status: function () {
        //        return ws.readyState;
        //    },
        //    send: function (message) {
        //        if (angular.isString(message)) {
        //            ws.send(message);
        //        }
        //        else if (angular.isObject(message)) {
        //            ws.send(JSON.stringify(message));
        //        }
        //    }
        //};

        var methods = {
            collection: collection,
            get: function() {
                ws.send(JSON.stringify({ action: 'get' }));
            }
        };

        return methods;
    });