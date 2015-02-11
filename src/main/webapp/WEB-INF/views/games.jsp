<!DOCTYPE HTML>
<html lang="en">
<head>
  <link href="assets/style.css" rel="stylesheet" type="text/css" />
  <script src="../../libs/jquery/jquery-2.1.3.min.js"></script>
</head>
<body ng-app="gameApp">

<div id="divGames" ng-controller="GameCtrl" class="container">

  <div ng-repeat="games in games">
      <span>{{game.name}}</span>
  </div>
</div>

<script>
  angular.element(document.getElementById('divGames')).scope().getGames();
</script>

<script src="libs/sockjs/sockjs.min.js" type="text/javascript"></script>
<script src="libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
<script src="libs/angular/angular.min.js"></script>
<script src="libs/lodash/lodash.min.js"></script>
<script src="libs/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="app/app.js" type="text/javascript"></script>
<script src="app/controllers.js" type="text/javascript"></script>
<script src="app/services.js" type="text/javascript"></script>
</body>
</html>
