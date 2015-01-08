Region = function (startPoint, endPoint) {
    this.startPoint = startPoint;
    this.endPoint = endPoint;
}

Region.prototype.centerPoint = function () {
    var x1 = this.startPoint.x;
    var x2 = this.endPoint.x;
    var y1 = this.startPoint.y;
    var y2 = this.endPoint.y;

    return new Vector2D(
            x1 + (x2 - x1) / 2,
            y1 + (y2 - y1) / 2
    )
}