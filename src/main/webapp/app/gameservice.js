(function(angular, SockJS, Stomp, _, undefined) {
  angular.module("gameApp.services").service("GameService", function($q, $timeout) {

    var service = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    };

    service.RECONNECT_TIMEOUT = 30000;
    service.CONNECT_TIMEOUT = 1000;

    service.SOCKET_URL = "/game";

    service.GAME_TOPIC = "/topic/game";
    service.GAME_BROKER = "/app/game";

    service.receive = function() {
      return listener.promise;
    };

    service.getGames = function() {
      $timeout(function() {
        getGames();
      }, this.CONNECT_TIMEOUT);
    };

    var getGames = function() {
      socket.stomp.send(service.GAME_BROKER, {
        priority: 9
      }, JSON.stringify({
      }));
    };

    var reconnect = function() {
      $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };

    //callback handler to receive games from server
    var handleReceiveGames = function(data) {
      var games = JSON.parse(data);

      console.log(games);

      return games;
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