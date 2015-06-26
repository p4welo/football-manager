angular.module('football-manager', ["ngTouch", "ngResource", "ui.router", "pascalprecht.translate"])

    .run(function ($rootScope, $translate) {
        $rootScope.setLanguage = function (lang) {
            $translate.use(lang);
        }
    })

    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/teamSelect');
    })

    .controller("teamListCtrl", function ($scope, $timeout, teamHttpService) {
        $scope.proceeding = false;
        teamHttpService.list().$promise.then(
            function (result) {
                $scope.teamList = result;
            }
        );
        $scope.resolveTeamClass = function (team) {
            if (team == $scope.hostTeam || team == $scope.guestTeam) {
                return 'active';
            }
            return "";
        };

        $scope.select = function (team) {
            if ($scope.hostTeam == team) {
                $scope.hostTeam = null;
                return;
            }
            else if ($scope.guestTeam == team) {
                $scope.guestTeam = null;
                return;
            }
            if ($scope.hostTeam == null) {
                $scope.hostTeam = team;
            }
            else if ($scope.guestTeam == null) {
                $scope.guestTeam = team;
            }
        };
        $scope.teamsReady = function () {
            return $scope.hostTeam != null && $scope.guestTeam != null;
        };
        $scope.proceed = function () {
            $scope.proceeding = true;
            teamHttpService.simulate({
                hostId: $scope.hostTeam.id,
                guestId: $scope.guestTeam.id
            }).$promise.then(
                function (result) {
                    $scope.simulation = result;
                    $scope.hostTeam = result.hostTeam;
                    $scope.guestTeam = result.guestTeam;
                    $scope.events = result.eventList;
                }
            )
        };
        $scope.hostScored = 0;
        $scope.guestScored = 0;
        $scope.inProgress = false;
        $scope.currentTime = 0;
        $scope.hostPossession = 50;


        function matchIteration() {
            $timeout(function () {
                $scope.currentTime++;
                var e = _.findWhere($scope.events, {'time': $scope.currentTime});
                $scope.hostPossession = 50 + e.hostPossession - e.guestPossession;

                if (e.type == 'GOAL') {
                    $scope.hostScored = e.hostScores;
                    $scope.guestScored = e.guestScores;
                    $scope.actualEvents.push(e);
                }
                else if (e.type == "ACTION") {
                    $scope.actualEvents.push(e);
                }

                if ($scope.currentTime < 90) {
                    matchIteration();
                }
                else {
                    $scope.inProgress = false;
                }
            }, 500);
        };

        $scope.start = function () {
            $scope.currentTime = 0;
            $scope.inProgress = true;
            matchIteration();
        };
        $scope.resolvePerformer = function (event) {
            if (_.includes(event.message, 'opportunity')) {
                if (event.hostAction) {
                    return $scope.hostTeam.name;
                }
                else {
                    return $scope.guestTeam.name;
                }
            }
            return "";
        };

        $scope.resolveRowStyle = function (event) {
            if (event.type == 'GOAL') {
                if (event.hostAction) {
                    return {'background-color' : $scope.hostTeam.color};
                }
                else {
                    return {'background-color' : $scope.guestTeam.color};
                }
            }
            return "";
        }

        $scope.actualEvents = [];
    });