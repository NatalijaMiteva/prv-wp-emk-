FirstApp.controller('FavoriteController',
  [
    '$scope',
    '$location',
    'Favorite',
    '$routeParams',
    function ($scope, $location, Favorite, $routeParams) {


      $scope.entities = Favorite.myFavoriteItems({
        id: $routeParams.id
      });



    }]);
