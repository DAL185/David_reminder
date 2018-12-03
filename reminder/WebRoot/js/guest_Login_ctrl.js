
var app = angular.module("myApp",[]);
app.controller("guest_Login_ctrl",function($scope,$http){
	$scope.guest_name = "";
	$scope.guest_pwd = "";	
	
	
	
	$scope.guest_doLogin = function(){
		//alert("kk");
		$scope.guest = {"guest_name": $scope.guest_name, "guest_pwd":$scope.guest_pwd};
		//alert($scope.guest_phone);
		//alert($scope.guest)
		$http({
			method : 'POST',//请求方式
			url	   : 'servlet/guest_Login_servlet',//提交地址
			data   : $.param($scope.guest),//提交参数
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			//alert(data);
			if (data == "success"){
				location.href='admin-guest_member_list.html';
			}else if(data == "failed"){
				alert("用户名或密码错误！");
				$scope.guest_name="";
				$scope.guest_pwd="";
			}
		});
		
	};
	
	$scope.guest_doRegister=function(){
		location.href="admin-guest_register.html";
	};
	
});