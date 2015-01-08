/**
 * Created by parado on 2014-12-15.
 */

var game = new Phaser.Game(900, 450, Phaser.AUTO, 'pitch', {
    preload: preload,
    create: create,
    update: update,
    render: render
});

var pitch;

function preload() {
    game.physics.startSystem(Phaser.Physics.ARCADE);
    game.load.audio('loop', ['assets/audio/loop.mp3', 'assets/audio/loop.ogg'])
    game.load.audio('kick', ['assets/audio/kick.mp3', 'assets/audio/kick.ogg'])

    game.load.image('pitch', 'assets/img/pitch.jpg');
    game.load.image('team1', 'assets/img/team1.png');
    game.load.image('team2', 'assets/img/team2.png');
    game.load.image('ball', 'assets/img/ball.png');
    game.load.image('back', 'assets/img/back.png');
}

function create() {
    game.world.setBounds(0, 0, 900, 450);
    game.add.sprite(0, 0, 'back');
    var music = game.add.audio('loop', 1, true);
    music.play('', 0, 1, true);

    pitch = new Pitch(game);
    pitch.create();
}

function update() {
    pitch.update();

}

function render() {
    game.debug.text('0 : 0', 45, 32);
}