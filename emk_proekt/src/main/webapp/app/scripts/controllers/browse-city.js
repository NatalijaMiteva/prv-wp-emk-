/**
 * Created by riste_000 on 3/18/2015.
 */

FirstApp.controller('BrowseCityController', [
  '$scope',
  'crudService',
  '$routeParams',
  'AdvertService',
  function ($scope, crudService, $routeParams, AdvertService) {
    var advertService = crudService('adverts');
    $scope.advert = advertService.get({
      id: $routeParams.id
    });

    $scope.entities = AdvertService.findByCity({
      id: $routeParams.id
    });


  }]);
