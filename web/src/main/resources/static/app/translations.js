angular.module('football-manager')

    .config(function ($translateProvider) {

        $translateProvider.translations('pl', {
            'very.close' : "By³o blisko!",
            'awful.pass' : "Kiepskie podanie do napastnika",
            'fantastic.finish' : "Fantastyczne wykoñczenie akcji!",
            'bad.pass' : "To by³o z³e podanie..."
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