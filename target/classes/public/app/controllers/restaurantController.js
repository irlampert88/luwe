(function(){	
	'use strict';

	angular.module('app')
		.controller("RestaurantAddController", ['$scope', 'RestaurantService', RestaurantAddController])
		.controller("RestaurantEditController", ['$scope', '$routeParams', 'RestaurantService', RestaurantEditController])
		.controller("RestaurantListController", ['$scope', 'RestaurantService', RestaurantListController]);
	
	function RestaurantAddController($scope, RestaurantService){
		var service = RestaurantService;
		var self = this;
		$scope.register = new Register();  
		
		function Register(id, nick, wifiPassword, canRepeatOnWeek, observation) {
			this.id = id;
		    this.nick = nick;
		    this.wifiPassword = wifiPassword;
		    this.canRepeatOnWeek = canRepeatOnWeek;
		    this.observation = observation;
		}
		
		$scope.submitForm = save;
		function save() {
			service.save($scope, $scope.register);
        }   
	}
	
	function RestaurantEditController($scope, $routeParams, RestaurantService){
		var service = RestaurantService;
		var self = this;
		$scope.register = service.findById($routeParams.id);
		
		$scope.submitForm = save;
		function save() {
			service.update($scope, $scope.register);
        }   
	}
	
    function RestaurantListController($scope, RestaurantService){
    	var service = RestaurantService;
    	var self = this;
        $scope.register;  

        $scope.removeRegister = removeRegister;
        $scope.selectRegister = selectRegister;
        
        init();
        
        function init() {
        	findAll();
        }        
        
        function findAll() {
        	$scope.registers = service.findAll();
        }
        
        function selectRegister(register) {
        	$scope.register = register;
        }
        
        function removeRegister() {
        	service.remove($scope.register, $scope.registers);
        }    
    }     
    
})();