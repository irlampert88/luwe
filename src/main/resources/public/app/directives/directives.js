(function(){	
	'use strict';

	angular.module('app')
		
		.directive('crudheader', function() {
			return {
				scope : {
					kind: '@'
				},
				restrict : 'E',
				templateUrl: '/views/directive-templates/crudheader-template.html',
				link : function(scope, elem) {
					var type = scope.kind;
					scope.icon = Kinds[type].icon; 
					scope.title = Kinds[type].name;
				}
			};
		})
		
		.directive('dialogconfirm', function() {
			return {
				scope : {
					modalid: '@',
					text: '@',
					action: '&'
				},
				restrict : 'E',
				templateUrl: '/views/directive-templates/dialog-confirm-template.html',
				link : function(scope, elem) {
					scope.fireConfirmAction = function() {
						scope.action();
					}
				}
			};
		})
		
		.directive('dialog', function() {
			return {
				scope : {
					modalid: '@',
					title: '@',
					icon: '@',
					width: '@'
				},
				transclude: {
					'dbody': 'dialogBody', // mandatory transclusion
					'dfooter': '?dialogFooter'  // optional transclusion
				},
	            replace: true,
				restrict: 'E',
				templateUrl: '/views/directive-templates/dialog-template.html'
			};
		})
		
		;
})();