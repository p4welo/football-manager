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
    game.load.audio('start', ['assets/audio/start.mp3', 'assets/audio/start.ogg'])
    game.load.audio('goal', ['assets/audio/goal.mp3', 'assets/audio/goal.ogg'])

    game.load.image('pitch', 'assets/img/pitch.jpg');
    game.load.image('team1', 'assets/img/team1.png');
    game.load.image('team2', 'assets/img/team2.png');
    game.load.image('ball', 'assets/img/ball.png');
    game.load.image('back', 'assets/img/back.png');
}

function create() {
    game.world.setBounds(0, 0, 900, 450);
    game.add.sprite(0, 0, 'back');
    game.add.audio('loop', 0.5, true).play('', 0, 0.3, true);

    pitch = new Pitch(game);
    pitch.create();
}

function update() {
    pitch.update();

}

function render() {
    game.debug.text(pitch.hostGoal.scoredGoals + ' : ' + pitch.guestGoal.scoredGoals, 45, 32);
}

function start() {
    pitch.start();
}