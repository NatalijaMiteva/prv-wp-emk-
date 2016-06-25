/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Favorite', ['$resource', 'settings', function($resource, settings) {

  return $resource('/data/rest/favorite_items/:id', {}, {
    myFavoriteItems: {
      method: 'GET',
      url: "/data/rest/favorite_items/my",
      isArray: true
    }
  });

}]);
