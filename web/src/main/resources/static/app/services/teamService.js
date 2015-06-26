angular.module('football-manager')

    .factory('teamHttpService', function ($resource) {
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

    .factory("teamService", function () {

        var hostTeam, guestTeam;

        return {
            setHostTeam : function (team) {
                hostTeam = team;
            },
            setGuestTeam : function(team) {
                guestTeam = team;
            },
            getHostTeam : function () {
                return hostTeam;
            },
            getGuestTeam : function() {
                return guestTeam;
            }
        }
    })
;