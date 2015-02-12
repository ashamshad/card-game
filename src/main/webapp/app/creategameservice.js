(function(angular, SockJS, Stomp, _, undefined) {
  angular.module("gameApp.services").service("CreateGameService", function($q, $timeout) {

    var service = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    };

    service.RECONNECT_TIMEOUT = 30000;

    service.SOCKET_URL = "/game";

    service.GAME_TOPIC = "/topic/createGame";
    service.GAME_BROKER = "/app/createGame";

    service.receive = function() {
      return listener.promise;
    };

    service.createGame = function(gameName) {
      socket.stomp.send(service.GAME_BROKER, {
        priority: 9
      }, JSON.stringify({
        gameName: gameName
      }));
    };

    var reconnect = function() {
      $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };

    //callback handler to receive games from server
    var handleReceiveGames = function(data) {
      var returnMessage = JSON.parse(data);

      console.log("Return message from createGame : " + returnMessage);

      return returnMessage;
    };

    var startListener = function() {
      socket.stomp.subscribe(service.GAME_TOPIC, function(data) {
        listener.notify(handleReceiveGames(data.body));
      });
    };

    var initialize = function() {
      socket.client = new SockJS(service.SOCKET_URL);
      socket.stomp = Stomp.over(socket.client);
      socket.stomp.connect({}, startListener);
      socket.stomp.onclose = reconnect;
    };

    initialize();
    return service;
  });
})(angular, SockJS, Stomp, _);