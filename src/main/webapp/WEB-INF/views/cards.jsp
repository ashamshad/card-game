<!DOCTYPE HTML>
<html lang="en">
<head>
  <link href="assets/style.css" rel="stylesheet" type="text/css" />
 </head>
<body ng-app="gameApp">
<div ng-controller="CardCtrl" class="container">
  <form ng-submit="shuffleCards()" name="messageForm">
    <button>Send</button>
  </form>

  <br>
  <br>
    <div ng-repeat="card in cards">
      <div ng-id="{{card.id}}" class="card">
        <img ng-src="{{card.icon}}" ng-click="testImage($index)" border=0/>
      </div>
    </div>

</div>

<script src="libs/sockjs/sockjs.min.js" type="text/javascript"></script>
<script src="libs/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
<script src="libs/angular/angular.min.js"></script>
<script src="libs/lodash/lodash.min.js"></script>
<script src="libs/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="app/app.js" type="text/javascript"></script>
<script src="app/cardcontroller.js" type="text/javascript"></script>
<script src="app/cardservice.js" type="text/javascript"></script>
</body>
</html>
