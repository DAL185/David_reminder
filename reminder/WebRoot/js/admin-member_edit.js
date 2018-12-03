var app=angular.module("myApp",['ionic']);
app.controller("admin-member_edit",function($scope,$http){
	$scope.name="";
	var url=location.search;
	var name=url.substring(url.indexOf("name=")+5);
    //alert(name);

	$http({
		method :'GET',
		url :'servlet/edit_member_servlet?name='+name,
		data :$.param($scope.name),
		headers :{'Content-Type':'application/x-www-form-urlencoded'}
	}).success(function(res){
		//alert(res);
		//$scope.reminders=res;
		
		var json = res;
		let arr=[];
        var jsondata = [];              
        for (var key in json) {
        	arr.push(key)
            //jsondata.push([json[i]]);
            
        }
        arr.sort();
        
        for(var i in arr){
        	jsondata.push([json[i]]);
        }
        //alert(jsondata[0]);
        var chart = {
  		      type: 'column'
  		   };
  		   var title = {
  		      text: 'unfinished reminders during the last 7 days'   
  		   };
  		   var subtitle = {
  		      text: 'Source: runoob.com'
  		   };
  		   var xAxis = {
  		      categories: ['today','yesterday','2 days ago','3 days ago','4 days ago','5 days ago','6 days ago','7 days ago'],
  		      crosshair: true
  		   };
  		   var yAxis = {
  		      min: 0,
  		      title: {
  		         text: 'number'         
  		         
  		      }      
  		   };
  		   var tooltip = {
  		      headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
  		      pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
  		         '<td style="padding:0"><b>{point.y:.1f} reminders </b></td></tr>',
  		      footerFormat: '</table>',
  		      shared: true,
  		      useHTML: true
  		   };
  		   var plotOptions = {
  		      column: {
  		         pointPadding: 0.2,
  		         borderWidth: 0
  		      }
  		   };  
  		   var credits = {
  		      enabled: false
  		   };
  		   
  		   var series= [{
  		        name: 'patient',
  		            data: [jsondata[0],jsondata[1],jsondata[2],jsondata[3],jsondata[4],
  		                   jsondata[5],jsondata[6],jsondata[7]]
  		        
  		   }];     
  		      
  		   var json = {};   
  		   json.chart = chart; 
  		   json.title = title;   
  		   json.subtitle = subtitle; 
  		   json.tooltip = tooltip;
  		   json.xAxis = xAxis;
  		   json.yAxis = yAxis;  
  		   json.series = series;
  		   json.plotOptions = plotOptions;  
  		   json.credits = credits;
  		   $('#container').highcharts(json);
  		  
  	

	}).error(function(data){
		alert("系统错误，请联系管理员！");
	});

	
		   
	
	
	
	$scope.editMember=function(){
		//alert("111");
		$http({
			method :'POST',
			url :'servlet/add_member_servlet?action=editmember',
			data :$.param($scope.formData),
			headers :{'Content-Type':'application/x-www-form-urlencoded'}
		}).success(function(data){
			if(data=="success"){
				alert("修改成功");
			   location.href="admin-member_list.html";
			}else if(data=="failed"){
				alert("修改失败");		
			}
		}).error(function(data){
			alert("系统错误，请联系管理员！");
		});
	};
	
	$scope.giveup_editMember=function(){
		location.href="admin-member_list.html";
	};
	
});




