function loadJs(script) {
    $("head").append('<script type="text/javascript" src="' + script + '"></script>');
}

loadJs("webjars/bootstrap/3.3.5/js/bootstrap.min.js");
loadJs("webjars/bootstrap-material-design/0.3.0/js/material.min.js");
loadJs("webjars/bootstrap-material-design/0.3.0/js/ripples.min.js");
loadJs("webjars/angularjs/1.4.1/angular.min.js");
loadJs("webjars/angular-resource/1.4.0/angular-resource.min.js");
loadJs("webjars/angular-translate/2.7.2/angular-translate.min.js");
loadJs("webjars/lodash/3.9.3/lodash.min.js");