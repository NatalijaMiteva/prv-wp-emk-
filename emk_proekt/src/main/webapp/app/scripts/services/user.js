
FirstApp.factory('UserService', function($resource) {

	return $resource('/data/rest/user/:action', {}, {
		authenticate : {
			method : 'POST',
			params : {
				'action' : 'authenticate'
			},
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		},
    getByUsername : {
      method : 'GET',
      url:"/data/rest/users/by/:username",
    }
	});
});
