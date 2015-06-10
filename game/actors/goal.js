Goal = function (game, center, isLeftGoal, ball) {
    this.game = game;
    this.center = center;
    this.ball;

    var higherPost = center.sub(0,75);
    var lowerPost = center.add(0, 75);

    this.leftPost = isLeftGoal ? higherPost : lowerPost;
    this.rightPost = isLeftGoal ? lowerPost : higherPost;
    this.facing = isLeftGoal ? new Vector2D(1, 0) : new Vector2D(-1, 0);
    this.scoredGoals = 0;
}

Goal.prototype.create = function () {
    this.game.add.graphics(0, 0)
        .lineStyle(0)
        .beginFill(0xFFFFFF, 1)
        .drawCircle(this.leftPost.x, this.leftPost.y, 5);

    this.game.add.graphics(0, 0)
        .lineStyle(0)
        .beginFill(0xFFFFFF, 1)
        .drawCircle(this.rightPost.x, this.rightPost.y, 5);
}

Goal.prototype.update = function () {
}

Goal.prototype.scored = function () {
    if (false) {
        this.scoredGoals++;
        game.add.audio('goal', 1, false).play('', 0, 1, false);
    }
//    TODO: method returns true if the ball has crossed the goal line (oldPosition & currentPosition) and increments scoredGoals++
    return false;
}