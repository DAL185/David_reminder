var app = angular.module("myApp",[]);
app.controller("Login_ctrl",function($scope,$http){
	$scope.username = "";
	$scope.pwd = "";	
	
	
	
	$scope.doLogin = function(){
		//alert($scope.username);
		$scope.user = {"username": $scope.username, "pwd":$scope.pwd};
		$http({
			method : 'POST',//请求方式
			url	   : 'servlet/Login_servlet',//提交地址
			data   : $.param($scope.user),//提交参数
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("用户名或密码错误！");
				$scope.username="";
				$scope.pwd="";
			}
		});
		
	};
	
	$scope.doRegister=function(){
		
		location.href="admin-register.html";
	};
	
	
	
});