Vector2D = function (x, y) {
    this.x = x;
    this.y = y;
}
Vector2D.prototype.sub = function (vector) {
    return new Vector2D(this.x - vector.x, this.y - vector.y);
}
Vector2D.prototype.sub = function (x, y) {
    return new Vector2D(this.x - x, this.y - y);
}

Vector2D.prototype.add = function (vector) {
    return new Vector2D(this.x + vector.x, this.y + vector.y);
}
Vector2D.prototype.add = function (x, y) {
    return new Vector2D(this.x + x, this.y + y);
}