Pitch = function (game) {
    this.game = game;
    this.playingArea = {
        bounds: game.world.getBounds(),
        centerX: game.world.centerX,
        centerY: game.world.centerY
    }
    this.gameOn = false;
    this.gameOnAt = null;
    this.goalkeeperHasBall = false;
    this.regions = calculateRegions(this.playingArea.bounds.width, this.playingArea.bounds.height);

    this.ball = new Ball(game, this.playingArea);
    this.hostGoal = new Goal(this.game, this.playingArea.bounds.x, this.playingArea.bounds.height / 2, true, this.ball);
    this.guestGoal = new Goal(this.game, this.playingArea.bounds.width, this.playingArea.bounds.height / 2, false, this.ball);
    this.hostTeam = new Team(game, this.ball, "team1", this.regions, [6, 1, 13, 2, 14]);
    this.guestTeam = new Team(game, this.ball, "team2", this.regions, [11, 4, 16, 3, 15]);

    function calculateRegions(width, height) {
        var xSteps = width / 6;
        var ySteps = height / 3;

        var result = [];
        var startX = 0;
        var startY = 0;
        for (var y = 0; y < 3; y++) {
            for (var x = 0; x < 6; x++) {

                var x1 = startX + x * xSteps;
                var y1 = startY + y * ySteps;

                var x2 = startX + (x + 1) * xSteps;
                var y2 = startY + (y + 1) * ySteps;

                var region = new Region(
                    new Vector2D(x1, y1),
                    new Vector2D(x2, y2)
                );
                result.push(region)
            }
            startX = 0;
        }
        return result;
    }
}

Pitch.prototype.create = function () {
    this.ball.create();
    this.hostTeam.create();
    this.guestTeam.create();
    this.hostGoal.create();
    this.guestGoal.create();
}

Pitch.prototype.update = function () {

    if (this.gameOn) {
//        IF GOAL WAS SCORED
        if (this.hostGoal.scored()) {
            this.backToHome(true);
        }
        else if (this.guestGoal.scored()) {
            this.backToHome(false);
        }
    }
    else {
//        IF IT IS TIME TO GET BACK TO THE GAME
        if (this.gameOnAt != null && this.gameOnAt < new Date().getTime()) {
            game.add.audio('start', 1, false).play('', 0, 1, false);
            this.gameOn = true;
            console.log("Game back on")
        }
    }

    this.ball.update();
    this.hostTeam.update();
    this.guestTeam.update();
    this.hostGoal.update();
    this.guestGoal.update();
}

Pitch.prototype.start = function () {
    this.backToHome(true);
}

Pitch.prototype.backToHome = function (hostTeamStarts) {
    this.gameOn = false;
    var t = new Date();
    t.setSeconds(t.getSeconds() + 5);
    this.gameOnAt = t;

    this.hostTeam.backToHome(hostTeamStarts);
    this.guestTeam.backToHome(!hostTeamStarts);
    this.ball.backToHome();
}