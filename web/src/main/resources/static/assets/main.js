$(document).ready(function () {
    $.material.init();
});

function toggleWell() {
    if ($("#contactWell").hasClass("hidden") || $("#contactWell").hasClass("slideOutRight")) {
        $("#contactWell").removeClass("hidden")
            .removeClass("slideOutRight")
            .addClass("slideInRight");
    }
    else {
        $("#contactWell").removeClass("visible")
            .removeClass("slideInRight")
            .addClass("slideOutRight");
    }
}