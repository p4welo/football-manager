Ball = function (game, playingArea) {
    this.entity = new MovingEntity(game, "ball", 5);
    this.playingArea = playingArea;

    this.oldPosition = null;
    this.owner = null;
}

Ball.prototype.create = function () {
    this.entity.placeAtPosition(new Vector2D(this.playingArea.centerX, this.playingArea.centerY))
}

Ball.prototype.update = function () {
    if (this.owner != null) {
        this.entity.object.x = this.owner.entity.object.x;
        this.entity.object.y = this.owner.entity.object.y;
    }
}

Ball.prototype.kick = function (direction, force) {
    this.owner = null;

    // TODO: force
    var ds = Math.pow(Math.pow(direction.x, 2) + Math.pow(direction.y, 2), 0.5);
    var dt = Math.pow(2 * ds / force, 0.5) * 200
    this.entity.kick(new Vector2D(direction.x, direction.y), dt, true);
}

Ball.prototype.trap = function (owner) {
    this.entity.movement.stop();
    this.owner = owner;
}

Ball.prototype.placeAtPosition = function (newPosition) {

}