var stage, balls;

function init() {
    stage = new createjs.Stage("myCanvas");
    balls = [];

    createjs.Ticker.addEventListener("tick", tick);
}

function tick() {
    stage.update();
}

var socket = new SockJS('fmSocket');
var client = Stomp.over(socket);
client.connect('user', 'password', onConnect);

function onConnect () {
    client.subscribe("/fmInitialized", onInitialized);
    client.send("/fmInit", {}, {});
};

function onInitialized(message) {
    var pitch = JSON.parse(message.body);
    console.log(pitch);
    for (var i = 0; i < 5; i++) {
        var ball = new createjs.Shape();
        ball.graphics.beginFill("#000000").drawCircle(0, 0, 10);
        ball.x = 50;
        ball.y = 200;
        balls.push(ball);
        stage.addChild(ball);
    }

}