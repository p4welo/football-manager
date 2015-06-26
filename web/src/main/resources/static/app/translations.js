angular.module('football-manager')

    .config(function ($translateProvider) {

        $translateProvider.translations('pl', {
            'static.begin': "Rozpocznij",
            'static.rematch': "Rewanż!",
            'static.name': "Nazwa",
            'static.power': "Siła",
            'static.select.teams': "Wybierz drużyny",
            'static.guest.team': "Goście",
            'static.host.team': "Gospodarze",
            'static.simulation': "Symulacja",
            'static.match.begin': "No to zaczynajmy",
            'static.match.finished': "Dziękujemy za uwagę",

            'opportunity.0': "mogą zaatakować...",
            'opportunity.1': "próbują sklecić z tego coś sensownego...",
            'opportunity.2': "mają szansę na kontratak...",
            'opportunity.3': "konstruują atak pozycyjny...",
            'opportunity.4': "posyłają piłkę na skrzydło...",
            'opportunity.5': "błyskawicznie rozgrywa piłkę...",
            'opportunity.6': "próbują podań na jedno tempo...",

            'loss.0': "Uderzył daleko w trybuny.",
            'loss.1': "Ta akcja będzie śnić im się po nocach",
            'loss.2': "Tym razem przeciwnik okazał się skuteczniejszy.",
            'loss.3': "Bramkarz popisał się świetną paradą.",
            'loss.4': "Strzał zablokowany przez obrońcę.",
            'loss.5': "Uff! Było blisko!",
            'loss.6': "Kiepskie podanie do napastnika!",

            'goal.0': "I PIŁKA W BRAMCE!",
            'goal.1': "FANTASTYCZNE WYKOŃCZENIE!",
            'goal.2': "PRAWDZIWY MAJSTERSZTYK!",
            'goal.3': "KAPITALNE UDERZENIE!",
            'goal.4': "GOOOOOOOOOOOL!",
            'goal.5': "CO ZA AKCJA!",
            'goal.6': "I MAMY GOLA!"
        });
        $translateProvider.translations('en', {
            'static.begin': "Begin",
            'static.rematch': "Rematch",
            'static.name': "Name",
            'static.power': "Power",
            'static.select.teams': "Select teams",
            'static.guest.team': "Guest",
            'static.host.team': "Host",
            'static.simulation': "Simulation",
            'static.match.begin': "So let's begin",
            'static.match.finished': "Thank you for watching",

            'opportunity.0': "mogą zaatakować...",
            'opportunity.1': "próbują sklecić z tego coś sensownego...",
            'opportunity.2': "mają szansę na kontratak...",
            'opportunity.3': "konstruują atak pozycyjny...",
            'opportunity.4': "posyłają piłkę na skrzydło...",
            'opportunity.5': "błyskawicznie rozgrywa piłkę...",
            'opportunity.6': "próbują podań na jedno tempo...",

            'loss.0': "Uderzył daleko w trybuny.",
            'loss.1': "Ta akcja będzie śnić im się po nocach",
            'loss.2': "Tym razem przeciwnik okazał się skuteczniejszy.",
            'loss.3': "Bramkarz popisał się świetną paradą.",
            'loss.4': "Strzał zablokowany przez obrońcę.",
            'loss.5': "Uff! Było blisko!",
            'loss.6': "Kiepskie podanie do napastnika!",

            'goal.0': "I PIŁKA W BRAMCE!",
            'goal.1': "FANTASTYCZNE WYKOŃCZENIE!",
            'goal.2': "PRAWDZIWY MAJSTERSZTYK!",
            'goal.3': "KAPITALNE UDERZENIE!",
            'goal.4': "GOOOOOOOOOOOL!",
            'goal.5': "CO ZA AKCJA!",
            'goal.6': "I MAMY GOLA!"
        });

        $translateProvider.preferredLanguage('pl');
    }
);