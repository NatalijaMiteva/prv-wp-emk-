/*
 * Directive for generic combo (select)
 *
 */

FirstApp.directive('favoriteDisplay', [
  'crudService',
  '$location',
  'settings',
  function(crudService, $location) {
    return {
      restrict : 'AE',
      scope : {
        entity : '=',
        shoppingCart: '=',
        bean: '@'
      },
      compile : function(tElem, attrs) {

        return function(scope, elem, attrs) {

        };
      },
      controller : function($scope, $element, crudService,  $cookies, settings) {

        var Advert = crudService('adverts');
        $scope.entities = Advert.query();

        var ordersService = crudService('order_items');

        $scope.addToCart = function () {
          ordersService.save({
            advert: {
              id: $scope.entity.id
            }
          });
        }

      },
      templateUrl : 'directives/favorite-display.html'
    };
  } ]);
