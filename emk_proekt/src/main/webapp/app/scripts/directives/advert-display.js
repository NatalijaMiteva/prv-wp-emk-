/*
 * Directive for generic combo (select)
 *
 */

FirstApp.directive('advertDisplay', [
  'crudService',
  '$location',
  function (crudService, $location) {
    return {
      restrict: 'AE',
      scope: {
        entity: '='
      },
      compile: function (tElem, attrs) {


        return function (scope, elem, attrs) {

        };
      },
      controller: function ($scope, $element, crudService, $cookies) {
        var ordersService = crudService('order_items');

        console.log("controller advert dis");
        console.log($scope.entity.advertName);

        $scope.display = function () {
          $location.path('/adverts/details/' + $scope.entity.id);
        };

       $scope.addToCart = function () {
          ordersService.save({
            book: {
              id: $scope.entity.id
            }
          });
        }

      },
      templateUrl: 'directives/example-display.html'
    };
  }]);

