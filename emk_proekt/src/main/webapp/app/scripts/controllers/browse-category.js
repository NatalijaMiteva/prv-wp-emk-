/**
 * Created by riste_000 on 3/18/2015.
 */

FirstApp.controller('BrowseCategoryController', [
  '$scope',
  'crudService',
  '$routeParams',
  'AdvertService',
  function ($scope, crudService, $routeParams, AdvertService) {
    var categoryService = crudService('categories');
    $scope.catID = $routeParams.id;
    $scope.cat = categoryService.get({
      id: $routeParams.id
    });

    $scope.entities = AdvertService.findByCategory({
      id: $routeParams.id
    });


  }]);
