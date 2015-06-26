angular.module('football-manager')

    .config(function ($stateProvider) {
        $stateProvider.state('simulation', {
            url: "/simulation",
            templateUrl: "app/match/simulation/simulation.html",
            controller: "simulationCtrl"
        });
    })

    .controller("simulationCtrl", function ($scope, $timeout, $state, teamHttpService, teamService) {
        $scope.hostTeam = teamService.getHostTeam();
        $scope.guestTeam = teamService.getGuestTeam();

        if (!$scope.hostTeam || !$scope.guestTeam) {
            $state.go("teamSelect");
        }

        function resetMatch() {
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
            );

            $scope.hostScored = 0;
            $scope.guestScored = 0;
            $scope.matchInProgress = false;
            $scope.matchFinished = false;
            $scope.currentTime = 0;
            $scope.hostPossession = 50;
            $scope.actualEvents = [];
        }

        resetMatch();

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
                    $scope.matchInProgress = false;
                    $scope.matchFinished = true;
                }
            }, 500);
        };

        $scope.canStart = function () {
            return $scope.simulation && !$scope.matchFinished;
        };

        $scope.canReset = function () {
            return $scope.matchFinished;
        };

        $scope.start = function () {
            $scope.currentTime = 0;
            $scope.matchInProgress = true;
            matchIteration();
        };

        $scope.isGoal = function (event) {
            return event.type == 'GOAL';
        }

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

        $scope.rematch = function () {
            resetMatch();
        }

        $scope.resolveMessageRowStyle = function (event) {
            if (event.type == 'GOAL') {
                if (event.hostAction) {
                    return {'background-color': $scope.hostTeam.color};
                }
                else {
                    return {'background-color': $scope.guestTeam.color};
                }
            }
            return "";
        };

        $scope.resolveHostPossessionStyle = function () {
            return {width: hostPossession + '%', 'background-color': hostTeam.color};
        };

        $scope.resolveGuestPossessionStyle = function () {
            return {width: 100 - hostPossession + '%', 'background-color': guestTeam.color};
        }
    });