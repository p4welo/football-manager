angular.module("fm", [])

    .controller("indexController", function ($scope) {

        var stage, players = {}, ball;

        function init() {
            stage = new createjs.Stage("pitchArea");
            createjs.Ticker.addEventListener("tick", tick);
        }

        function tick() {
            stage.update();
        }

        var socket = new SockJS('rest/fmSocket');
        var client = Stomp.over(socket);
        client.connect('user', 'password', onConnect);

        function onConnect() {
            client.subscribe("/fmInitialized", onInitialized);
            client.subscribe("/fmMove", onMove);
            client.send("/fmInit", {}, {});
        };

        function onMove(message) {

        }

        function insertPlayers(playerList, color) {
            playerList.forEach(function (p) {
                drawPlayer(p, color);
            })
        }

        function drawPlayer(p, color) {
            var playerBall = new createjs.Shape();
            playerBall.graphics.beginFill(color).drawCircle(0, 0, 10);
            console.json("INSERT PLAYER: " + p);
            playerBall.x = p.x;
            playerBall.y = p.y;
            players[p.id] = playerBall;
            stage.addChild(playerBall);
        }

        function onInitialized(message) {
            var pitch = JSON.parse(message.body);

            insertPlayers(pitch.guestTeam.players, pitch.guestTeam.color);
            drawPlayer(pitch.guestTeam.goalKeeper, pitch.guestTeam.color);

            insertPlayers(pitch.hostTeam.players, pitch.hostTeam.color);
            drawPlayer(pitch.hostTeam.goalKeeper, pitch.hostTeam.color);

            console.table(players);
        }

        $scope.init = init();

        $scope.dupa = function () {
            createjs.Tween.get(players[0]).to({y: 0}, 500, createjs.Ease.getPowOut(3));
        }

    })