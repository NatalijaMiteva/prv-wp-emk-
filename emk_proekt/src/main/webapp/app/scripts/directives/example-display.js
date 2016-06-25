/*
 * Directive for generic combo (select)
 *
 */

FirstApp.directive('exampleDisplay', [
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
        var favoriteService = crudService('favorite_items');

        $scope.addToCart = function () {
          ordersService.save({
            advert: {
              id: $scope.entity.id
            }
          });
        }

        $scope.addToFavorite = function () {
          favoriteService.save({
            advert: {
              id: $scope.entity.id
            }
          });
        }

      },
      templateUrl : 'directives/example-display.html'
    };
  } ]);
