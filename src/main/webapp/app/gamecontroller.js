(function(angular) {
  angular.module("gameApp.controllers").controller("GameCtrl", function($scope, $log, GameService) {
    $scope.games = [];


    $scope.getGames = function() {
      GameService.getGames();
    };

    GameService.receive().then(null, null, function(games) {
      $scope.games = games;
      alert(games[0]);
    });

    $scope.getGames();

  });
})(angular);