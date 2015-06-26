angular.module('football-manager')

    .config(function ($stateProvider) {
        $stateProvider.state('teamSelect', {
            url: "/teamSelect",
            templateUrl: "app/match/teamSelect/teamSelect.html",
            controller: "teamSelectCtrl"
        });
    })

    .controller("teamSelectCtrl", function ($scope, $state, teamHttpService, teamService) {

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
            teamService.setHostTeam($scope.hostTeam);
            teamService.setGuestTeam($scope.guestTeam);
            $state.go('simulation');
        };
    });