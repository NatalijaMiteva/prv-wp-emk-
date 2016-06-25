/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Order', ['$resource', 'settings', function($resource, settings) {

  return $resource('/data/rest/order_items/:id', {}, {
    getMyOrders: {
      method: 'GET',
      url: "/data/rest/order_items/my",
      isArray: true
    },
    checkPay: {
      method: 'POST',
      url: "/data/rest/order_items/check_pay"
    },
    pay: {
      method: 'POST',
      url: 'https://www.paypal.com',
      params : {
        action: '/cgi-bin/webscr',
        cmd: '_cart',
        upload: '1',
        business: 'test_button@gmail.com',
        item_name_1: 'Item Name 1',
        amount_1: '1.00',
        item_name_2: 'Item Name 2',
        amount_2: '2.00'
      },
      headers : {
        'Content-Type' : 'application/x-www-form-urlencoded'
      }
    }

  });

}]);
