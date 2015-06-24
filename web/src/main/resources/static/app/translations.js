angular.module('football-manager')

    .config(function ($translateProvider) {

        $translateProvider.translations('pl', {
            'very.close' : "By�o blisko!",
            'awful.pass' : "Kiepskie podanie do napastnika",
            'fantastic.finish' : "Fantastyczne wyko�czenie akcji!",
            'bad.pass' : "To by�o z�e podanie..."
        });
        $translateProvider.translations('en', {
            'very.close' : "That was close!",
            'awful.pass' : "Awful pass to the striker",
            'fantastic.finish' : "Fantastic finish!",
            'bad.pass' : "Bad pass..."
        });

        $translateProvider.preferredLanguage('pl');
    }
);