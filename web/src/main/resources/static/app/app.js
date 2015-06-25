angular.module('football-manager', ["ngResource", 'pascalprecht.translate'])

    .run(function ($rootScope, $translate) {
        $rootScope.setLanguage = function (lang) {
            $translate.use(lang);
        }
    })


    .controller("teamListCtrl", function ($scope, $timeout, teamService) {
        $scope.proceeding = false;
        teamService.list().$promise.then(
            function (result) {
                $scope.teamList = result;
            }
        );
        $scope.resolveTeamClass = function (team) {
            if (team == $scope.hostTeam || team == $scope.guestTeam) {
                return 'active';
            }
            return "";
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
            teamService.simulate({
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

        }
        $scope.hostScored = 0;
        $scope.guestScored = 0;
        $scope.inProgress = false;
        $scope.currentTime = 0;
        $scope.hostPossession = 50;

        function matchIteration() {
            $timeout(function () {
                $scope.currentTime++;
                $scope.events.forEach(function (e) {
                    if (e.time == $scope.currentTime) {
                        $scope.hostPossession += e.hostPossession ? 1 : -1;
                        console.table(e);
                        if (e.scoringOpportunity) {
                            $scope.actualEvents.push(e);
                            if (e.goalScored) {
                                if (e.hostPossession ) {
                                    $scope.hostScored++;
                                }
                                else {
                                    $scope.guestScored++;
                                }
                            }
                        }
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
    })

















    .factory('teamService', function ($resource) {
        return $resource(null, null, {
            list: {
                url: "team/list",
                method: 'GET',
                isArray: true
            },
            simulate: {
                url: "team/:hostId/:guestId/simulate",
                method: 'GET'
            }
        });
    })
;