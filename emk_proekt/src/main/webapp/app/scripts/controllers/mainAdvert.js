FirstApp.controller('AdvertController', [
  '$scope',
  '$modal',
  'crudService',
  '$routeParams',
  '$rootScope',
  'toaster',
  '$filter',
  'ngTableParams',
  'AdvertService',
  function ($scope, $modal, crudService, $routeParams, $rootScope, toaster, $filter, ngTableParams, AdvertService) {

    var Category = crudService('adverts');
    $scope.entities = Category.query();

    $scope.dateToday = new Date();

    $scope.queryData = AdvertService.getQueryData({
      id: $routeParams.id
    });

    Category.query(function (data) {
      $scope.entities = data;
      $scope.tableParams.reload();
    });
    if ($routeParams.id) {
      $scope.entity = service.get({
        id: $routeParams.id
      });
    } else {
      $scope.entity = {};
    }

    /*
     if ($routeParams.id) {
     $scope.entity = Category.get({
     id : $routeParams.id
     });
     } else {
     $scope.entity = {};
     }
     */

    var m = $modal({
      scope: $scope,
      template: 'views/add_new_advert.html',
      show: false
    });


    $scope.add = function (id) {
      console.log('finki: ' + id);
      $scope.entity.publishingDate = new Date();
      $scope.entity.owner = $rootScope.user;
      Category.save($scope.entity, function (data) {
          $scope.entity = {};
          $scope.entities = Category.query();
          m.hide();
        }
        , function () {
          m.$promise.then(m.show);
        });
    };


    $scope.edit = function (id) {
      $scope.entity = Category.get({
        id: id
      });
      Category.save($scope.entity, function (data) {
          $scope.entities = Category.query();
          m.hide();
        }
        , function () {
          m.$promise.then(m.show);
        });


    };

    $scope.save = function () {
      console.log($rootScope.user);
      $scope.entity.publishingDate = new Date();
      $scope.entity.owner = $rootScope.user;
      Category.save($scope.entity, function (data) {
        $scope.entity = {};
        $scope.entities = Category.query();
        m.hide();

      });
    };

    $scope.remove = function (id) {
      Category.remove({
        id: id
      }, function () {
        $scope.entities = Category.query();
      });
    };

    var data = $scope.entities;

    console.log("console data");
    console.log(data);

    $scope.tableParams = new ngTableParams({
      page: 1, // show first page
      count: 3, // count per page
      sorting: {
        name: 'asc' // initial sorting
      }
    }, {
      total: data.length, // length of data
      getData: function ($defer, params) {
        console.log("called");
        // use build-in angular filter
        var filteredData = params.filter()['advertName'] ? $filter(
          'filter')($scope.entities, params.filter())
          : $scope.entities;
        console.log(params.filter()['advertName']);

        var orderedData = params.sorting() ? $filter('orderBy')(
          filteredData, params.orderBy()) : $scope.entities;
        console.log(orderedData);

        params.total(orderedData.length); // set total for
        if (orderedData.length != 0) {
          $defer.resolve(orderedData.slice((params.page() - 1 )
            * params.count(), params.page() * params.count()));
        }
      }
    });

  }]);
