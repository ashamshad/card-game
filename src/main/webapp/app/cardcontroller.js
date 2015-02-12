(function(angular) {
  angular.module("gameApp.controllers").controller("CardCtrl", function($scope, $log, GameService) {
    $scope.cards = [];

    $scope.shuffleCards = function() {
      GameService.getShuffledCards();
    };

    GameService.receive().then(null, null, function(shuffledCards) {
      $scope.cards = shuffledCards;
    });

  });
})(angular);