/*
// Mock响应模板
		Mock.mock('http://test.com', {
		    "users|200": [{   // 随机生成5到10个数组元素
		        'name': '@name',  // 名称
		        'id|+1': 1,    // 属性值自动加 1，初始值为1
		        'priority|1-3': 0,   // 18至28以内随机整数, 0只是用来确定类型
		        
		    }]
		});
 
		angular.module('myApp', [])
 
		.service('userService', ['$http', function ($http) {
			return {
				doRequest:function(){
					return $http({
						url:'http://test.com',
						method:'post'
					});
				}
			};
		}])
		.controller('admin-member_list', ['$scope', 'userService', function ($scope, userService) {
			userService.doRequest().then(function success(response){
				console.log(response);
				$scope.users = response.data.users;
			}, function error(){
				console.error('error...');
			})
		}]);

*/
var app = angular.module("myApp",['ionic']);

app.controller("admin-member_list",function($scope,$http){
	
	$scope.username={
			username:"",
	};
	
	$scope.keywords="";
	//alert($scope.username);
	$http({
		method : 'POST',
		url    : 'servlet/search_member_servlet',
		data   : $.param($scope.username), 
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
	
	}).success(function(data){
		$scope.members=data;
	}).error(function(data){
		alert("系统错误，请联系管理员");
		
	});
	
	$scope.findMember=function(){
		$scope.keywords=$("input[name='keywords']").val();
		
	
		$scope.keyword = {"keywords": $scope.keywords};
		
		$http({
			method : 'POST',//请求方式
			url	   : 'servlet/find_member_servlet', 
			data   : $.param($scope.keyword),//提交参数
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		})
		
		
		
		.success(function(data){
		
			$scope.members=data;
			
			
		})
		.error(function(data){
			alert("系统错误，请联系管理员！");
		});
		
	};
	
	$scope.edit=function(name){
		location.href='admin-member_edit.html?name='+name;
	};	
	
	$scope.del=function(id){
		//alert(id);
		$http({
			method :'GET',
			url :'servlet/delete_member_servlet?id='+id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("delete sucessfully!");
			location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("failed to delete!");		
			}
		})
		.error(function(id){
			alert("系统错误，请联系管理员！");
		});
	};
	
	
});	

	