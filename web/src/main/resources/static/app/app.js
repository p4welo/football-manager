angular.module('football-manager', ["ngResource"])

    .controller("matchCtrl", function ($scope, $timeout, testService) {
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

        $scope.test = testService.query();

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

    .factory('testService', function($resource){
            return $resource('dupa', {}, {
                query: {
                    method:'GET',
                    isArray:true
                }
            });
        })
;