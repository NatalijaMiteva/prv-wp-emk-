/**
 * Created by riste_000 on 3/18/2015.
 */

FirstApp.controller('AvdertDescriptionController', [
  '$scope',
  '$routeParams',
  '$rootScope',
  'crudService',
  'AdvertService',
  function ($scope, $routeParams,$rootScope, crudService, AdvertService) {

	$scope.entity = AdvertService.getAdvertDetails({
      id: $routeParams.id
    });
  $rootScope.advert = $scope.entity;

    var Advert = crudService('advert/apply');

    $scope.save = function() {
      $scope.advertEntity = {};
      $scope.advertEntity.advert = $rootScope.advert;
      $scope.advertEntity.owner = $rootScope.advert.owner;
      $scope.advertEntity.user = $rootScope.user;

      Advert.save($scope.advertEntity, function(data) {
        $scope.advertEntity = {};
      });

    };

  }]);
