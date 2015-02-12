(function(angular) {
  angular.module("gameApp.controllers").controller("CreateGameCtrl", function($scope, $log, CreateGameService) {
    $scope.gameName = "";

    $scope.createGame = function() {
      CreateGameService.createGame($scope.gameName);
    };

    CreateGameService.receive().then(null, null, function() {
      $log.info('Game created');
    });

  });
})(angular);