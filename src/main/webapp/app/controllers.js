(function(angular) {
  angular.module("gameApp.controllers").controller("GameCtrl", function($scope, $log, GameService) {
    $scope.cards = [];
    $scope.max = 140;

    $scope.getGames = function() {
      GameService.getGames();
    };

    $scope.shuffleCards = function() {
      GameService.getShuffledCards();
    };

    GameService.receive().then(null, null, function(shuffledCards) {
      $scope.cards = shuffledCards;
    });

    $scope.testImage = function(cardIndex) {
      alert($scope.cards[cardIndex].id);
    };

  });
})(angular);