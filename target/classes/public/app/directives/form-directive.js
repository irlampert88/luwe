(function(){	
	'use strict';

	angular.module('app')
	
		.directive('inputtext', function() {
			return {
				restrict : 'E',
				scope : {
					label: '@',
					type: '@',
					required: '@',
					ngmodel: '='
				},
				replace: true,
				templateUrl: '/views/directive-templates/inputtext-template.html',
			};
		})
		
		.directive('inputlabel', function() {
			return {
				restrict : 'E',
				scope : {
					label: '@',
					type: '@',
					required: '@',
					ngmodel: '='
				},
				replace: true,
				templateUrl: '/views/directive-templates/inputlabel-template.html',
			};
		})
		
		.directive('inputcheck', function() {
			return {
				restrict : 'E',
				scope : {
					label: '@',
					required: '@',
					ngmodel: '='
				},
				replace: true,
				templateUrl: '/views/directive-templates/inputcheck-template.html',
			};
		})
	
		.directive('inputtextarea', function() {
			return {
				restrict : 'E',
				scope : {
					label: '@',
					maxlength: '@',
					required: '@',
					ngmodel: '='
				},
				replace: true,
				templateUrl: '/views/directive-templates/inputtextarea-template.html',
			};
		})
		
		.directive('chooser', function() {
			return {
				restrict : 'E',
				scope : {
					label: '@',
					required: '@',
					value: '=',
					model: '=',
					registerstolist: '=',
					columntitles: '=',
					valuestolist: '=',
					kind: '@'
				},
				replace: true,
				templateUrl: '/views/directive-templates/chooser-template.html',
				link : function(scope, elem) {
					var type = scope.kind;
					scope.icon = Kinds[type].icon; 
					scope.title = Kinds[type].name;
					
					scope.selectRegister = function(item) {
						scope.model = item;
						var buttonId = "#" + scope.label + "-chooserDialogButtonId";
						$(buttonId).click();
					}
					
					scope.fireClearAction = function() {
						scope.model = null;
					}
				}
			};
		})
		
		;
})();