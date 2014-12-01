angular.module("fm", [])

    .controller("indexController", function ($scope) {

        var PLAYER_TEXT_X = -4;
        var PLAYER_TEXT_Y = -6;
        var PLAYER_TEXT_FONT = "bold 14px Arial";


        var stage, players = {}, ball;

        function init() {
            stage = new createjs.Stage("pitchArea");
            createjs.Ticker.setInterval(25);
            createjs.Ticker.setFPS(50);
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
            client.subscribe("/fmMove", function (message) {
                onMove(JSON.parse(message.body));
            });
            client.send("/fmInit", {}, {});
        };

        function onMove(body) {
            console.table(body);
        }

        function insertPlayers(playerList, color) {
            playerList.forEach(function (p) {
                drawPlayer(p, color);
            })
        }

        function drawPlayer(p, color) {
            var container = new createjs.Container();
            var playerBall = new createjs.Shape();
            playerBall.graphics.beginFill(color).drawCircle(0, 0, 10);
            container.x = p.x;
            container.y = p.y;
            var txtColor;
            if (color == "yellow") {
                txtColor = "black";
            }
            else {
                txtColor = "white";
            }
            var text = new createjs.Text(p.number, PLAYER_TEXT_FONT, txtColor);
            text.x = PLAYER_TEXT_X;
            text.y = PLAYER_TEXT_Y;
            container.addChild(playerBall);
            container.addChild(text);
            stage.addChild(container);
            players[p.id] = container;
        }

        function drawBall(b) {
            ball = new createjs.Shape();
            ball.graphics.beginFill("white").drawCircle(0, 0, 4);
            ball.x = 450;
            ball.y = 225;
            stage.addChild(ball);
        }

        function onInitialized(message) {
            var pitch = JSON.parse(message.body);

            insertPlayers(pitch.guestTeam.players, pitch.guestTeam.color);
            drawPlayer(pitch.guestTeam.goalKeeper, pitch.guestTeam.color);

            insertPlayers(pitch.hostTeam.players, pitch.hostTeam.color);
            drawPlayer(pitch.hostTeam.goalKeeper, pitch.hostTeam.color);

            drawBall(pitch.ball);
        }

        $scope.init = init();

        $scope.randomize = function () {
            for (var i in players) {
                createjs.Tween.get(players[i], {override:true}).to({y: Math.floor(Math.random() * 450), x: Math.floor(Math.random() * 900)}, 2000, createjs.Ease.getPowOut(3));
            }
        }
    })