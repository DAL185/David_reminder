var app = angular.module("myApp",[]);
app.controller("admin-member_add",function($scope,$http){

	$scope.formData={
			name:"",
			description:"",
			time:"",
			priority:"",
			id:"",
	};
	
	$scope.addMember=function(){
		//alert("kk");
	$http({
		method : 'POST',//请求方式
		url	   : 'servlet/add_member_servlet?action=addmember', //提交地址
		data   : $.param($scope.formData),//提交参数
		headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	})
	alert("successfully added!")
	.success(function(data){
		if (data=="success"){
			alert("添加成功！");
			location.href="admin-member_list.html";
		}else if(data=="failed"){
			alert("添加失败！");
		 }
	})
	.error(function(data){
		alert("系统错误，请联系管理员！");
	});
	
	};
	
	$scope.giveup_addMember=function(){
		location.href="admin-member_list.html";
	};
	
});