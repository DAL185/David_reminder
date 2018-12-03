var app = angular.module("myApp",[]);
app.controller("admin-guest_member_list",function($scope,$http){
	//alert("kk");

	$scope.guest_name={
			guest_name:"",
	};
	
	
	$http({
		method : 'POST',
		url    : 'servlet/guest_have_reminder_servlet',
		data   : $.param($scope.guest_name), 
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
	}).success(function(data){
		if(data=="success"){
			alert("You have a new reminder!");
		}else if(data=="failed"){
			
		}
	}).error(function(data){
		alert("系统错误，请联系管理员");
		
	});
	
	$http({
		method : 'POST',
		url    : 'servlet/guest_search_member_servlet',
		data   : $.param($scope.guest_name), 
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'}
	
	}).success(function(res){
		$scope.member_reminders=res;
		
	
	})
	.error(function(data){
		alert("系统错误，请联系管理员");
		
	});
	
	$scope.finish=function(id){
		//alert(id);
		$http({
			method :'GET',
			url :'servlet/guest_finish_reminder_servlet?id='+id,
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("You finished that reminder!");
			location.href="admin-guest_member_list.html";
			}else if(data=="failed"){
				alert("You failed to finish that reminder!");		
			}
		})
		.error(function(id){
			alert("系统错误，请联系管理员！");
		});
	};
			
});
