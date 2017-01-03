(function(){	
	'use strict';
	
	angular.module('app')
		.directive('tableremovebutton', function() {
			return {
				scope : {
					selectaction: '&',
					removeaction: '&'
				},
				restrict : 'E',
				templateUrl: '/views/directive-templates/tableremovebutton-template.html',
				
				link : function(scope, elem) {
					scope.fireSelectAction = function() {
						scope.selectaction();
					}
					
					scope.fireRemoveAction = function() {
						scope.removeaction();
					}
				}
			};
		})
	
		.directive('tablepl', function($parse) {
			return {
				scope : {
					tableid: '@',
					selectaction: '&', //Na declaração do atributo, obrigatoriamente o parametro precisa ser 'item'. Ex.: 'selectUser(item)'
					removeaction: '&',
					registers: '=',
					columntitles: '=',
					valuestolist: '=',
					hideactions: '@',
					hidedeleteaction: '@',
					rowselection: '@',
					pagetoedit: '@',
					editlabel: '@',
					rowstyle: '@'
				},
				transclude: {
					'customtableactions': '?custom-actions'
				},
				replace: true,
				restrict : 'E',
				templateUrl: '/views/directive-templates/tablepl-template.html',
				
				link : function(scope, elem, attrs) {
					scope.editlabel = (scope.editlabel ? scope.editlabel : "Editar");
					
					scope.fireRowSelected = function(item) {
						if (scope.rowselection) {
							scope.fireSelectAction(item);
						}
					}
					
					scope.fireSelectAction = function(item) {
						scope.selectaction({item: item});
					}
					
					scope.fireRemoveAction = function() {
						scope.removeaction();
					}
				}
			};
		});
})();