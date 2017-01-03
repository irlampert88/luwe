(function(){	
	'use strict';

	angular.module('app')
		.controller("ElectionEditController", ['$scope', '$routeParams', 'notify', 'RestaurantService', 'ElectorService', 'ElectionService', ElectionEditController])
		.controller("ElectionListController", ['$scope', '$filter', 'ElectionService', ElectionListController]);
	
	function ElectionEditController($scope, $routeParams, notify, ElectorService, RestaurantService, ElectionService){
		var service = ElectionService;
		var self = this;
		$scope.register = service.findById($routeParams.id);
		$scope.vote = new Vote();  
		
		$scope.newVote = newVote;
		
		function Vote(restaurant, elector, electionid) {
		    this.restaurant = restaurant;
		    this.elector = elector;
		    this.electionid = electionid;
		}
		
		init();
		
		function init() {
			$scope.restaurants = RestaurantService.findAll();
			$scope.electors = ElectorService.findAll();
			$scope.electeds = service.findElecteds($routeParams.id);
		}
		
		function newVote() {
			var newVote = $scope.vote;
			if (!newVote.restaurant || !newVote.elector) {
				notify.alert("Informe o Eleitor e Restaurante. Ambos são campos obrigatórios.")
				return;
			} else {
				newVote.electionid = $scope.register.id;
				service.addNewVote($scope, newVote);
			}
		}
	}
	
    function ElectionListController($scope, $filter, ElectionService){
    	var service = ElectionService;
    	var self = this;
        $scope.register;  

        $scope.selectRegister = selectRegister;
        $scope.save = save;
        
        init();

        function init() {
        	findAll();
        }        
        
        function save() {
        	service.save($scope, function() {
        		findAll();
        	});
        }  
        
        function findAll() {
        	$scope.registers = service.findAll();
        }
        
        function selectRegister(register) {
        	$scope.register = register;
        }
        
    }     
    
})();