var app = angular.module("myApp",[]);
app.controller("guest_Register_ctrl",function($scope,$http){
	$scope.guest_phone = "";
	$scope.guest_pwd = "";	
	
	
	
	$scope.submit = function(){
		//alert($scope.username);
		$scope.guest = {"guest_phone": $scope.guest_phone, "guest_pwd":$scope.guest_pwd};
		$http({
			method : 'POST',//请求方式
			url	   : 'servlet/guest_Register_servlet',//提交地址
			data   : $.param($scope.guest),//提交参数
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				alert("注册成功!")
				location.href="admin-guest_login.html";
			}else if(data=="failed"){
				alert("注册失败！");
				$scope.guest_phone="";
				$scope.guest_pwd="";
			}
		});
		
	};

	
});