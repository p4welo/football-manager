var stage, balls;

function init() {
    stage = new createjs.Stage("myCanvas");
    balls = [];
    for (var i = 0; i < 5; i++) {
        var ball = new createjs.Shape();
        ball.graphics.beginFill("#000000").drawCircle(0, 0, 10);
        ball.x = 50;
        ball.y = 200;
        balls.push(ball);
        stage.addChild(ball);
    }

    createjs.Ticker.addEventListener("tick", tick);
}

function tick() {
    stage.update();
}

var socket = new SockJS('random');
var client = Stomp.over(socket);

var onConnect = function () {
    client.subscribe("/data/0", function (message) {
        var response = JSON.parse(message.body);
        createjs.Tween.get(balls[0], {loop: false}).to({x: parseInt(response.x), y: parseInt(response.y)}, parseInt(response.v));

    });
    client.subscribe("/data/1", function (message) {
        var response = JSON.parse(message.body);
        createjs.Tween.get(balls[1], {loop: false}).to({x: parseInt(response.x), y: parseInt(response.y)}, parseInt(response.v));

    });
    client.subscribe("/data/2", function (message) {
        var response = JSON.parse(message.body);
        createjs.Tween.get(balls[2], {loop: false}).to({x: parseInt(response.x), y: parseInt(response.y)}, parseInt(response.v));

    });
    client.subscribe("/data/3", function (message) {
        var response = JSON.parse(message.body);
        createjs.Tween.get(balls[3], {loop: false}).to({x: parseInt(response.x), y: parseInt(response.y)}, parseInt(response.v));

    });
    client.subscribe("/data/4", function (message) {
        var response = JSON.parse(message.body);
        createjs.Tween.get(balls[4], {loop: false}).to({x: parseInt(response.x), y: parseInt(response.y)}, parseInt(response.v));

    });
};
client.connect('user', 'password', onConnect);