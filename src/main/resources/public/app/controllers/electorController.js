(function(){	
	'use strict';

	angular.module('app')
		.controller("ElectorAddController", ['$scope', 'ElectorService', ElectorAddController])
		.controller("ElectorEditController", ['$scope', '$routeParams', 'ElectorService', ElectorEditController])
		.controller("ElectorListController", ['$scope', 'ElectorService', ElectorListController]);
	
	function ElectorAddController($scope, ElectorService){
		var service = ElectorService;
		var self = this;
		$scope.register = new Register();  
		
		function Register(id, nick) {
			this.id = id;
		    this.nick = nick;
		}
		
		$scope.submitForm = save;
		function save() {
			service.save($scope, $scope.register);
        }   
	}
	
	function ElectorEditController($scope, $routeParams, ElectorService){
		var service = ElectorService;
		var self = this;
		$scope.register = service.findById($routeParams.id);
		
		$scope.submitForm = save;
		function save() {
			service.update($scope, $scope.register);
        }   
	}
	
    function ElectorListController($scope, ElectorService){
    	var service = ElectorService;
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