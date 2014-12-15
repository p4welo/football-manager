/**
 * Created by parado on 2014-12-15.
 */

var game = new Phaser.Game(960, 640, Phaser.AUTO, '', {
    preload: preload,
    create: create,
    update: update
});

function preload() {
    game.load.image('pitch', 'assets/img/pitch.jpg');
    game.load.image('player', 'assets/img/player.png');
}

var player, cursors;

function create() {
    game.world.setBounds(0, 0, 960, 640);
    game.add.sprite(0, 0, 'pitch');

    player = game.add.sprite(200, 150, 'player');

    //  We need to enable physics on the player
    game.physics.arcade.enable(player);
    player.animations.add('left', [0, 1, 2, 3], 10, true);
    player.animations.add('right', [5, 6, 7, 8], 10, true);

    cursors = game.input.keyboard.createCursorKeys();
}

function update() {


    player.body.velocity.x = 0;

    if (cursors.left.isDown)
    {
        //  Move to the left
        player.body.velocity.x = -150;

        player.animations.play('left');
    }
    else if (cursors.right.isDown)
    {
        //  Move to the right
        player.body.velocity.x = 150;

        player.animations.play('right');
    }
    else
    {
        //  Stand still
        player.animations.stop();

        player.frame = 4;
    }

    //  Allow the player to jump if they are touching the ground.
    if (cursors.up.isDown && player.body.touching.down)
    {
        player.body.velocity.y = -350;
    }
}