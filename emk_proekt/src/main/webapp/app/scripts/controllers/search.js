/**
 * Created by riste_000 on 4/8/2015.
 */

FirstApp.controller('SearchController', [
  '$scope',
  '$routeParams',
  '$location',
  'AdvertService',
  function ($scope, $routeParams, $location, AdvertService) {
    $scope.search = function () {
      $location.path("/search").search({
        text: $scope.searchField
      });
    };

    if ($routeParams.text) {
      $scope.entities = AdvertService.search({
        text: $routeParams.text
      });
    }
  }]);
