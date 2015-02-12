<!DOCTYPE HTML>
<html lang="en">
<head>
  <link href="assets/style.css" rel="stylesheet" type="text/css" />
</head>
<body ng-app="gameApp" >

<div id="divGames" ng-controller="CreateGameCtrl" class="container">

    <form ng-submit="createGame()" name="newGameForm">
        <input type="text" placeholder="New game name..." ng-model="gameName" />
        <div class="info">
            <button>Send</button>
        </div>
    </form>
</div>

<script src="libs/sockjs/sockjs.min.js" type="text/javascript"></script>
<script src="libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
<script src="libs/angular/angular.min.js"></script>
<script src="libs/lodash/lodash.min.js"></script>
<script src="libs/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="app/app.js" type="text/javascript"></script>
<script src="app/creategamecontroller.js" type="text/javascript"></script>
<script src="app/creategameservice.js" type="text/javascript"></script>

<script>
//  angular.element($('divGames')).scope().getGames();
</script>

</body>
</html>
