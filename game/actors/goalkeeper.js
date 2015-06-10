Goalkeeper = function (game, spriteName, team, homeRegion) {
    this.entity = new MovingEntity(game, spriteName, 10);
    this.game = game;
    this.spriteName = spriteName;
    this.team = team;
    this.homeRegion = homeRegion;
}

Goalkeeper.prototype.create = function () {

}

Goalkeeper.prototype.update = function () {

}
Goalkeeper.prototype.backToHome = function () {
    this.entity.placeAtPosition(this.homeRegion.centerPoint())
}