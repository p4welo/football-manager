angular.module('football-manager')

    .config(function ($translateProvider) {

        $translateProvider.translations('pl', {
            'static.begin': "Rozpocznij",
            'static.name': "Nazwa",
            'static.power': "Siła",
            'static.select.teams': "Wybierz drużyny",
            'static.guest.team': "Goście",
            'static.host.team': "Gospodarze",
            'static.simulation': "Symulacja",

            'very.close' : "Było blisko!",
            'awful.pass' : "Kiepskie podanie do napastnika",
            'fantastic.finish' : "Fantastyczne wykończenie akcji!",
            'bad.pass' : "To było złe podanie..."
        });
        $translateProvider.translations('en', {
            'static.begin': "Begin",
            'static.name': "Name",
            'static.power': "Power",
            'static.select.teams': "Select teams",
            'static.guest.team': "Guest",
            'static.host.team': "Host",
            'static.simulation': "Simulation",

            'very.close' : "That was close!",
            'awful.pass' : "Awful pass to the striker",
            'fantastic.finish' : "Fantastic finish!",
            'bad.pass' : "Bad pass..."
        });

        $translateProvider.preferredLanguage('pl');
    }
);