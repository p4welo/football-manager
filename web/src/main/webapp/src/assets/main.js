var carouselOpts = {
    items: 1,
    loop: false,
    center: true,
    margin: 10,
    URLhashListener: true,
    autoplayHoverPause: true,
    startPosition: 'URLHash',
    onInitialize: function () {
        //onCarouselInitialization();
    }
};

$(document).ready(function () {
    window.location.hash = '#1';
    $.material.init();
    $('.owl-carousel').owlCarousel(carouselOpts);
    $(function () {
        $(".navbar li").click(function () {
            $(".navbar li").removeClass("active");
            $(this).addClass("active");
        });
    });
});

function onCarouselInitialization() {
    setTimeout(function () {
        $(".loader").addClass("animated slideOutDown");
        $(".navbar-section").addClass("animated fadeInDown");
        $(".main-content").addClass("visible animated fadeIn");
        $("body").removeClass("loading");
    }, 2000);
}

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