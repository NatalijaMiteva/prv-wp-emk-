/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('AdvertService', ['$resource', 'settings', function ($resource, settings) {

  return $resource('/data/rest/adverts/:id', {}, {

	  findByCategory: {
      method: 'GET',
      url:"/data/rest/adverts/by_category/:id",
      isArray: true
    },

    getAdvertDetails: {
        method: 'GET',
        url:"/data/rest/adverts/details/:id"
      },

    search: {
        method: 'GET',
        url:'/data/rest/adverts/search',
        isArray: true
    },
    findByCity: {
      method: 'GET',
      url:  "/data/rest/adverts/by_city/:id",
      isArray: true
    },
    paged: {
      method: 'GET',
      url:"/data/rest/adverts/paged"
    },
    getQueryData:{
      method: 'GET',
      url:"/data/rest/adverts/query",
      isArray: true
    }
  });

}]);
