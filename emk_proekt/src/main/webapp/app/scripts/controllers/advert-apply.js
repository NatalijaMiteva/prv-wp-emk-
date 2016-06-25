FirstApp.controller('AdvertApplyController',
  [ '$scope',
    'crudService',
    '$routeParams',
    'toaster',
    '$rootScope',
    'AdvertApplicationsService',
    function($scope, crudService, $routeParams, toaster, $rootScope, AdvertApplicationsService) {

      $scope.applyUsers = AdvertApplicationsService.getUserList({
        id: $routeParams.id
      });
      $rootScope.userApplyList = $scope.applyUsers;

      $scope.applyAdverts = AdvertApplicationsService.getAdvertList({
        id: $routeParams.id
      });
      $rootScope.advertApplyList = $scope.applyAdverts;

    } ]);
