<!DOCTYPE HTML>
<html lang="en">
<head>
  <link href="assets/style.css" rel="stylesheet" type="text/css" />
  <script src="../../libs/jquery/jquery-2.1.3.min.js"></script>
</head>
<body>

<div id="newGameDiv" class="gameOptions" onclick="">
  <span class="spanGameOptions">NEW GAME</span>
</div>
<br>
<div id="joinGameDiv" class="gameOptions">
  <span class="spanGameOptions">JOIN GAME</span>
</div>

<script>
  $( "#newGameDiv" ).click(function() {
    window.location.replace("cards");
  });
</script>

</body>
</html>
