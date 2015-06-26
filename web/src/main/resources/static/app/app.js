angular.module('football-manager', ["ngTouch", "ngResource", "ui.router", "pascalprecht.translate"])

    .run(function ($rootScope, $translate) {
        $rootScope.setLanguage = function (lang) {
            $translate.use(lang);
        }
    })

    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/teamSelect');
    });