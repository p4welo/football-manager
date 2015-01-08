MovingEntity = function (game, spriteName, size) {
    this.game = game;
    this.spriteName = spriteName;
    this.size = size;
    this.object = null;
    this.movement = null;
}

MovingEntity.prototype.placeAtPosition = function (position) {
    if (this.object == null) {

        this.object = this.game.add.sprite(position.x, position.y, this.spriteName);
        this.game.physics.enable(this.object, Phaser.Physics.ARCADE);
        this.object.body.collideWorldBounds = true;
    }
    else {
        this.object.body.x = position.x;
        this.object.body.y = position.y;
    }
}

MovingEntity.prototype.move = function (position, time) {
    this.movement = this.game.add.tween(this.object.body).to({ x: position.x, y: position.y }, time, Phaser.Easing.Linear.None, true, 0, 0, false)
    this.movement.onComplete.add(function () {
        this.movement = null;
    }, this)
}

MovingEntity.prototype.stop = function () {
    if (this.movement != null) {
        this.movement.stop();
    }
}

MovingEntity.prototype.kick = function (direction, force) {
    this.movement = this.game.add.tween(this.object.body).to({ x: direction.x, y: direction.y }, 3000, Phaser.Easing.Cubic.Out, true, 0, 0, false)
    this.movement.onComplete.add(function () {
        this.movement = null;
    }, this)
    var music = game.add.audio('kick', 1, false);
    music.play('', 0, 1, false);
}

MovingEntity.prototype.inMove = function () {
    return this.movement != null;
}

MovingEntity.prototype.update = function () {

}
