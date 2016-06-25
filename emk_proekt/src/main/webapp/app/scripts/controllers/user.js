FirstApp.controller('UserController',
  ['$scope',
    'crudService',
    '$routeParams',
    'toaster',
    '$rootScope',
    function ($scope, crudService, $routeParams, toaster, $rootScope) {

      var Category = crudService('users/register');
      $scope.entities = Category.query();
      $scope.entity = {};

      $scope.edit = function (id) {
        $scope.entity = Category.get({
          id: id
        });
      };

      $scope.save = function () {
        if ($rootScope.userRole != undefined && $rootScope.userRole != null) {
          $scope.entity.role = $rootScope.userRole;
        } else {
          $scope.entity.role = "ROLE_ADMIN"
        }
        Category.save($scope.entity, function (data) {
          $scope.entity = {};
          $scope.entities = Category.query();
        });

      };

      $scope.remove = function (id) {
        Category.remove({
          id: id
        }, function () {
          $scope.entities = Category.query();
        });
      };

    }]);
