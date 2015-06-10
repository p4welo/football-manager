Player = function (game, spriteName, team, homeRegion) {
    this.entity = new MovingEntity(game, spriteName, 10);
    this.game = game;
    this.spriteName = spriteName;
    this.team = team;
    this.homeRegion = homeRegion;
}

Player.prototype.create = function () {
}

Player.prototype.update = function () {

}

Player.prototype.move = function (position, time) {
    this.entity.move(position, time)
}

Player.prototype.inMove = function () {
    return this.entity.inMove()
}

Player.prototype.backToHome = function () {
    this.entity.placeAtPosition(this.homeRegion.centerPoint())
}

Player.prototype.placeAtPosition = function (point) {
    this.entity.placeAtPosition(point)
}