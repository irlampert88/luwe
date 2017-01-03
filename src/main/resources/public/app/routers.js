(function(){	
	'use strict';

    angular.module("app")
		.config(['$routeProvider', '$httpProvider', viewRouter])
		;
	
	function viewRouter($routeProvider, $httpProvider){
		$routeProvider
		.when('/', {
			templateUrl : 'views/home.html',
			controller : 'Home as controller'
		})
		
		.when('/electorlist', {
			templateUrl : 'views/elector/electorList.html',
			controller : 'ElectorListController as controller'
		})	
		.when('/electornew', {
			templateUrl : 'views/elector/electorAddForm.html',
			controller : 'ElectorAddController as controller'
		})	
		.when('/electoredit/:id', {
			templateUrl : 'views/elector/electorEditForm.html',
			controller : 'ElectorEditController as controller'
		})	
		
		.when('/restaurantlist', {
			templateUrl : 'views/restaurant/restaurantList.html',
			controller : 'RestaurantListController as controller'
		})	
		.when('/restaurantnew', {
			templateUrl : 'views/restaurant/restaurantAddForm.html',
			controller : 'RestaurantAddController as controller'
		})	
		.when('/restaurantedit/:id', {
			templateUrl : 'views/restaurant/restaurantEditForm.html',
			controller : 'RestaurantEditController as controller'
		})	
		
		.when('/electionlist', {
			templateUrl : 'views/election/electionList.html',
			controller : 'ElectionListController as controller'
		})	
		.when('/electionnew', {
			templateUrl : 'views/election/electionAddForm.html',
			controller : 'ElectionAddController as controller'
		})	
		.when('/electionedit/:id', {
			templateUrl : 'views/election/electionEditForm.html',
			controller : 'ElectionEditController as controller'
		})
		
		.otherwise('/');
		
		$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';		
	}	
		
})();