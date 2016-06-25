FirstApp.controller('OrderController',
  [
    '$scope',
    'Order',
    '$location',
    function($scope, Order, $location) {

      $scope.totalPayment = 0;

      $scope.entities = Order.getMyOrders(function() {
        for(var i = 0; i < $scope.entities.length; i++) {
          $scope.totalPayment += 50;
        }
      });

      $scope.pay = function() {
        Order.checkPay({}, function() {
          $location.path("/pay_order");
        });
      }


    }]);
