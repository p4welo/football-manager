Team = function (game, pitch, ball, spriteName, regions, homeIndexes) {
    this.TEAM_STATE_WAITING = 0;
    this.TEAM_STATE_BACK_TO_HOME = 1;
    this.TEAM_STATE_MATCH = 2;

    this.game = game;
    this.ball = ball;
    this.pitch = pitch;
    this.spriteName = spriteName;
    this.regions = regions;
    this.homeIndexes = homeIndexes;

    this.homeRegions = resolveHomeRegions(regions, homeIndexes);
    this.players = createPlayers(this.homeRegions, spriteName, this);
    this.goalkeeper = new Goalkeeper(game, spriteName, this, this.homeRegions[0])

    this.receivingPlayer = null;
    this.closestToBallPlayer = null;
    this.controllingPlayer = null;
    this.supportingPlayer = null;

    this.state = Team.TEAM_STATE_WAITING;

    function resolveHomeRegions(regions, homeIndexes) {
        var result = [];
        for (var i = 0; i < homeIndexes.length; i++) {
            result.push(regions[homeIndexes[i]]);
        }
        return result;
    }

    function createPlayers(homeRegions, spriteName, team) {
        var result = [];
        for (var i = 1; i < homeRegions.length; i++) {
            var player = new Player(this.game, spriteName, team, homeRegions[i]);
            result.push(player);
        }
        return result;
    }
}

Team.prototype.create = function () {
    for (var i = 0; i < this.players.length; i++) {
        this.players[i].create();
    }
    this.goalkeeper.create();
}

Team.prototype.update = function () {
    function trapBall(player) {
        this.ball.owner = player;
    }

    if (this.state == Team.TEAM_STATE_WAITING) {
    }
    else if (this.state == Team.TEAM_STATE_BACK_TO_HOME) {

    }
    else if (this.state = Team.TEAM_STATE_MATCH) {


        for (var i = 0; i < this.players.length; i++) {
            this.game.physics.arcade.overlap(
                this.ball, this.players[i], trapBall(this.players[i]), null, this
            );
        }
    }
}

Team.prototype.backToHome = function (weHaveBall) {
    this.state = Team.TEAM_STATE_BACK_TO_HOME;
    var startI = 0;
    if (weHaveBall) {
        startI = 2;
        this.players[0].placeAtPosition(this.pitch.playingArea.center);
        this.players[1].placeAtPosition(this.pitch.playingArea.center.sub(0, 30));
    }
    for (var i = startI; i < this.players.length; i++) {
        this.players[i].backToHome();
    }
    this.goalkeeper.backToHome();
}

Team.prototype.play = function () {
    this.state = Team.TEAM_STATE_MATCH;


}