angular.module("fm", ['ngResource'])

    .controller("indexController", function ($scope, broadcastFactory) {

        var PLAYER_TEXT_X = -4;
        var PLAYER_TEXT_Y = -6;
        var PLAYER_TEXT_FONT = "bold 14px Arial";


        var stage, players = {}, ball;

        function drawPitchLine(fromX, fromY, toX, toY) {
            var PITCH_LINE_COLOR = "white";
            var PITCH_LINE_WIDTH = 3;

            var line = new createjs.Shape();
            line.graphics.setStrokeStyle(PITCH_LINE_WIDTH);
            line.graphics.beginStroke(PITCH_LINE_COLOR);
            line.graphics.moveTo(fromX, fromY);
            line.graphics.lineTo(toX, toY);
            line.graphics.endStroke();
            stage.addChild(line);
        }

        function drawPitch() {

//            PITCH BORDERS
            drawPitchLine(5, 5, 895, 5);
            drawPitchLine(5, 5, 5, 445);
            drawPitchLine(5, 445, 895, 445);
            drawPitchLine(895, 5, 895, 445);

//            MIDDLE LINE
            drawPitchLine(450, 5, 450, 445);

//            LEFT GOAL
            drawPitchLine(5, 150, 75, 150);
            drawPitchLine(75, 150, 75, 300);
            drawPitchLine(5, 300, 75, 300);

//            RIGHT GOAL
            drawPitchLine(825, 150, 895, 150);
            drawPitchLine(825, 150, 825, 300);
            drawPitchLine(825, 300, 895, 300);
        }

        function init() {
            stage = new createjs.Stage("pitchArea");
            createjs.Ticker.setInterval(25);
            createjs.Ticker.setFPS(50);
            createjs.Ticker.addEventListener("tick", tick);

            drawPitch();
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

        function calculateShift(object, x, y) {
            var dx = object.x - x;
            var dy = object.y - y;
            return Math.floor(Math.sqrt(dx * dx + dy * dy));
        }

        function moveObject(object, x, y, time, callback) {
            createjs.Tween.get(object, {override: true}).to({y: y, x: x}, time).call(callback());
        }

        function onMoveCompleted(objectId) {
//            client.send("/player/move/complete", {}, JSON.stringify({
//                'id' : object.id
//            }));
            broadcastFactory.moveCompleted({id: objectId});
        }

        function onMove(body) {
            var x = body.x;
            var y = body.y;
            var v = body.v;
            var id = body.id;
            var player = players[id];
            var ds = calculateShift(player, x, y);
            var time = ds * 1000 / v;

            moveObject(player, x, y, time, onMoveCompleted(id));
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
            $scope.loading = false;
            $scope.$apply();
        }

        $scope.init = init();
        $scope.start = function () {
            broadcastFactory.start();
        };
        $scope.loading = true;

        $scope.randomize = function () {
            for (var i in players) {
                createjs.Tween.get(players[i], {override: true}).to({y: Math.floor(Math.random() * 430) + 10, x: Math.floor(Math.random() * 880) + 10}, 2000, createjs.Ease.getPowOut(3));
            }
        }
    })

    .factory("broadcastFactory", function ($resource) {
        return $resource(null, null, {
            moveCompleted: {
                url: "rest/player/:id/move/complete",
                method: 'GET'
            },
            start: {
                url: "rest/start",
                method: 'GET'
            }
        });
    })