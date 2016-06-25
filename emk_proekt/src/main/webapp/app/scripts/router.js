/**
 * @ngdoc here we are configuring the module exposed through the FirstApp
 *        variable. The method receives an array that has a function as a last
 *        argument. Here, the angular inject the dependencies defined as strings
 *        in the array to the corresponding elements in the function. <br/> The
 *        $routeProvider is used to configure the routes. It maps templateUrl
 *        and optionally a controller to a given path. This is used by the
 *        ng-view directive. It replaces the content of the defining element
 *        with the content of the templateUrl, and connects it to the controller
 *        through the $scope.
 * @see https://docs.angularjs.org/guide/di
 */
FirstApp.config(['$routeProvider', function ($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'views/main.html',
    controller: 'AdvertController'
  });


  $routeProvider.when('/browse_category/:id', {
    templateUrl: 'views/browse_category.html',
    controller: 'BrowseCategoryController'
  });

  $routeProvider.when('/advert/details/:id', {
    templateUrl: 'views/advert_details.html',
    controller: 'AvdertDescriptionController'
  });

  $routeProvider.when('/advert/apply/details/:id', {
    templateUrl: 'views/advert_apply_details.html',
    controller: 'AdvertApplyController'
  });

  $routeProvider.when('/advert/apply/adverts/:id', {
    templateUrl: 'views/company_apply_advert_details.html',
    controller: 'AdvertApplyController'
  });

  $routeProvider.when('/browse_city/:id', {
    templateUrl: 'views/browse_city.html',
    controller: 'BrowseCityController'
  });

  $routeProvider.when('/login', {
    templateUrl: 'views/login.html',
    controller: 'LoginController'
  });


  $routeProvider.when('/categories', {
    templateUrl: 'views/category.html',
    controller: 'CategoryController'
  });

  $routeProvider.when('/users/register', {
	    templateUrl: 'views/user.html',
	    controller: 'UserController'
	  });

  $routeProvider.when('/books/:id?', {
    templateUrl: 'views/book.html',
    controller: 'BookController'
  });

  $routeProvider.when('/adverts/:id?', {
	    templateUrl: 'views/mainAdvert.html',
	    controller: 'AdvertController'
  });

  $routeProvider.when('/search', {
    templateUrl: 'views/search_results.html',
    controller: 'SearchController'
  });

  $routeProvider.when('/cities', {
	    templateUrl: 'views/city.html',
	    controller: 'CityController'
	  });

  $routeProvider.when('/order_items', {
	    templateUrl: 'views/order.html',
	    controller: 'OrderController'
	  });

  $routeProvider.when('/favorite_items', {
    templateUrl: 'views/favorite_item.html',
    controller: 'FavoriteController'

  });

	  $routeProvider.when('/pay_order', {
	    templateUrl: 'views/pay_order.html'
	  });


  $routeProvider.when('/404', {
    templateUrl: '404.html'
  });
  $routeProvider.otherwise({
    redirectTo: '/'
  });
}]);
