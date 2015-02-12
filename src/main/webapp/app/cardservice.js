(function(angular, SockJS, Stomp, _, undefined) {
  angular.module("gameApp.services").service("CardService", function($q, $timeout) {

    var service = {}, listener = $q.defer(), socket = {
      client: null,
      stomp: null
    };

    service.RECONNECT_TIMEOUT = 30000;
    service.IMAGE_PATH = "../images/cards/";

    service.SOCKET_URL = "/game";

    service.SHUFFLE_TOPIC = "/topic/shuffle";
    service.SHUFFLE_BROKER = "/app/shuffle";

    service.receive = function() {
      return listener.promise;
    };

    service.getShuffledCards = function() {
      socket.stomp.send(service.SHUFFLE_BROKER, {
        priority: 9
      }, JSON.stringify({
      }));

    };

    var reconnect = function() {
      $timeout(function() {
        initialize();
      }, this.RECONNECT_TIMEOUT);
    };

    //callback handler to receive hands from server
    var handleReceiveHands = function(data) {
      var hands = JSON.parse(data);

      var hand = hands[0];

      var cards = hand.cards;

      var arrayLength = cards.length;
      for (var i = 0; i < arrayLength; i++) {
        cards[i].icon = service.IMAGE_PATH + cards[i].id + '.png';
      }

      return cards;
    };

    var startListener = function() {
      socket.stomp.subscribe(service.SHUFFLE_TOPIC, function(data) {
        listener.notify(handleReceiveHands(data.body));
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