(function() {
    'use strict';
    
     angular.module("app")
        .factory("ElectionService",  ['$location', '$resource', 'notify', Election]);       
       
        function Election($location, $resource, notify) {
            var restResource = $resource('/elections/' + ':id', { id: '@_id' }, { update: { method: 'PUT' } });
            
            var service = {
        		save: save,
        		addNewVote: addNewVote,
                findElecteds: findElecteds,
                findAll: findAll,
                findById: findById
            };
            return service;

            function findElecteds(electionId) {
            	return $resource('/elections/electeds/:id', {id: '@id'}).query({id : electionId});
            }
            
            function addNewVote($scope, newVote) {
            	$resource('/elections/newvote').save(newVote, 
        			function(data, status) {
	        			$location.path('/electionlist');
	        			notify.success("Voto realizado com sucesso!");
		        	}, 
		        	function(response) {
		        		if (response.status == 412) {
		        			notify.danger("O eleitor " + newVote.elector.nick + " já votou hoje. Permitido apenas um voto por dia.");
		        		} else if (response.status == 417) {
		        			notify.danger("O restaurante " + newVote.restaurant.nick + " já foi eleito para um dia desta semana. Vote em outro.");
		        		} else {
		        			notify.danger("Não foi possível criar um novo registro.");
		        		}
		        	});;
            }
            
            function save($scope, eventOnSuccess){
            	restResource.save(null,
    	    		function(data, status) {
            			eventOnSuccess.apply();
            			notify.success("Eleição para o almoço de hoje, criada com sucesso!");
    	        	}, 
    	        	function(response) {
    	        		if (response.status == 412) {
    	        			notify.danger("Já existe eleição cadastrada para hoje.");
    	        		} else {
    	        			notify.danger("Não foi possível criar um novo registro.");
    	        		}
    	        	});
            };
            
            function findAll(){
            	return restResource.query(function(result) {
            		return result;
            	});
            };
            
            function findById(registerId){
            	return restResource.get({id:registerId});
            };
        }    
})();        