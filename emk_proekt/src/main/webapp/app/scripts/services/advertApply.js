/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('AdvertApplicationsService', ['$resource', 'settings', function ($resource, settings) {

  return $resource('/data/rest/advert/:id', {}, {

    getUserList: {
      method: 'GET',
      url:"/data/rest/advert/apply/details/:id",
      isArray: true
    },

    getAdvertList: {
      method: 'GET',
      url:"/data/rest/advert/apply/adverts/:id",
      isArray: true
    }

  });

}]);
