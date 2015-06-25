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
            'bad.pass' : "To było złe podanie...",

            'opportunity.0': "może zaatakować...",
            'opportunity.1': "próbuje sklecić z tego coś sensownego...",
            'opportunity.2': "ma szansę na kontratak...",
            'opportunity.3': "może zaatakować...",
            'opportunity.4': "może zaatakować...",

            'loss.0': "Uderzył daleko w trybuny.",
            'loss.1': "Ta akcja będzie śnić im się po nocach",
            'loss.2': "Tym razem przeciwnik okazał się skuteczniejszy.",
            'loss.3': "Bramkarz popisał się popisową paradą.",
            'loss.4': "Strzał zablokowany przez obrońcę.",

            'goal.0': "I PIŁKA W BRAMCE!",
            'goal.1': "FANTASTYCZNE WYKOŃCZENIE!",
            'goal.2': "PRAWDZIWY MAJSTERSZTYK!",
            'goal.3': "KAPITALNE UDERZENIE!",
            'goal.4': "I MAMY GOLA!"
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
            'bad.pass' : "Bad pass...",

            'opportunity.0': "może zaatakować...",
            'opportunity.1': "próbuje sklecić z tego coś sensownego...",
            'opportunity.2': "ma szansę na kontratak...",
            'opportunity.3': "może zaatakować...",
            'opportunity.4': "może zaatakować...",

            'loss.0': "Uderzył daleko w trybuny.",
            'loss.1': "Ta akcja będzie śnić im się po nocach",
            'loss.2': "Tym razem przeciwnik okazał się skuteczniejszy.",
            'loss.3': "Bramkarz popisał się popisową paradą.",
            'loss.4': "Strzał zablokowany przez obrońcę.",

            'goal.0': "I PIŁKA W BRAMCE!",
            'goal.1': "FANTASTYCZNE WYKOŃCZENIE!",
            'goal.2': "PRAWDZIWY MAJSTERSZTYK!",
            'goal.3': "KAPITALNE UDERZENIE!",
            'goal.4': "I MAMY GOLA!"
        });

        $translateProvider.preferredLanguage('pl');
    }
);