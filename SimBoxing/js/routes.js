angular.module('test').congfig(function($routeProvider){
	$routeProvider.when('/contact-us', {
		templateUrl: 'templates/pages/game/index.html',
	})
	.when('/game', {
		templateUrl: 'templates/pages/game/index.html',
	})
	.when('/our-story',{
		templateUrl: 'templates/pages/our-story/index.html',
	})
	.when('/', {
		templateUrl: 'templates/pages/game/index.html',
	})
	.otherwise( { redirectTo: '/' } );
});