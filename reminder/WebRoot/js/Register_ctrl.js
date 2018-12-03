var app = angular.module("myApp",[]);
app.controller("Register_ctrl",function($scope,$http){
	$scope.username = "";
	$scope.pwd = "";	
	
	
	
	$scope.submit = function(){
		//alert($scope.username);
		$scope.user = {"username": $scope.username, "pwd":$scope.pwd};
		$http({
			method : 'POST',//请求方式
			url	   : 'servlet/Register_servlet',//提交地址
			data   : $.param($scope.user),//提交参数
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).success(function(data){
			if (data=="success"){
				alert("注册成功!")
				location.href="admin-login.html";
			}else if(data=="failed"){
				alert("注册失败！");
				$scope.username="";
				$scope.pwd="";
			}
		});
		
	};
	
	
});