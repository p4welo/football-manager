var stage, balls;

function init() {
    stage = new createjs.Stage("pitchArea");
    balls = [];
    createjs.Ticker.addEventListener("tick", tick);
}

function tick() {
    stage.update();
}

var socket = new SockJS('rest/fmSocket');
var client = Stomp.over(socket);
client.connect('user', 'password', onConnect);

function onConnect () {
    client.subscribe("/fmInitialized", onInitialized);
    client.subscribe("/data/0", function (message) {
        console.log("PRZYSZŁO: " + message)
    });
    client.send("/rest/fmInit", {}, {});
};


function onInitialized(message) {
    var pitch = JSON.parse(message.body);
    console.log(pitch);
    for (var i = 0; i < 1; i++) {
        var ball = new createjs.Shape();
        ball.graphics.beginFill("#000000").drawCircle(0, 0, 10);
        ball.x = 0;
        ball.y = 0;
        balls.push(ball);
        stage.addChild(ball);
        createjs.Tween.get(ball).to({y:200}, 500, createjs.Ease.getPowOut(2));
    }
}