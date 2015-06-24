angular.module('football-manager', ["ngResource", 'pascalprecht.translate'])

    .run(function ($rootScope, $translate) {
        $rootScope.setLanguage = function (lang) {
            $translate.use(lang);
        }
    })

    .controller("matchCtrl", function ($scope, $timeout) {
        $scope.inProgress = false;
        $scope.currentTime = 0;
        $scope.hostPossession = 50;

        function matchIteration() {
            $timeout(function () {
                $scope.currentTime++;
                $scope.hostPossession += Math.floor(Math.random() * (5 + 5 + 1)) - 5;
                $scope.events.forEach(function (e) {
                    if (e.time == $scope.currentTime) {
                        $scope.actualEvents.push(e);
                    }
                })
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
        }

        $scope.actualEvents = [];
        $scope.events = [
            {
                isGoalScored: true,
                isHostAction: true,
                messageId: 'very.close',
                time: 5
            },
            {
                isGoalScored: false,
                isHostAction: true,
                messageId: 'awful.pass',
                time: 17
            },
            {
                isGoalScored: true,
                isHostAction: false,
                messageId: 'fantastic.finish',
                time: 24
            },
            {
                isGoalScored: false,
                isHostAction: true,
                messageId: 'bad.pass',
                time: 33
            },
            {
                isGoalScored: false,
                isHostAction: false,
                messageId: 'very.close',
                time: 40
            }
        ];
    })




    .controller("teamListCtrl", function ($scope, $timeout, teamService) {
        $scope.proceeding = false;
        teamService.list().$promise.then(
            function (result) {
                $scope.teamList = result;
            }
        );
        $scope.resolveTeamClass = function (team) {
            var result = "";
            if (team == $scope.hostTeam) {
                result = 'host-row';
            }
            else if (team == $scope.guestTeam) {
                result = 'guest-row';
            }
            return result;
        }

        $scope.select = function (team) {
            if ($scope.hostTeam == team) {
                $scope.hostTeam = null;
                return ;
            }
            else if ($scope.guestTeam == team) {
                $scope.guestTeam = null;
                return ;
            }
            if ($scope.hostTeam == null) {
                $scope.hostTeam = team;
            }
            else if ($scope.guestTeam == null){
                $scope.guestTeam = team;
            }
        }
        $scope.teamsReady = function () {
            return $scope.hostTeam != null && $scope.guestTeam != null;
        }
        $scope.proceed = function () {
            $scope.proceeding = true;
        }
    })

















    .factory('teamService', function ($resource) {
        return $resource(null, null, {
            list: {
                url: "team/list",
                method: 'GET',
                isArray: true
            }
        });
    })
;