<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
  $(function () {
	var t =	$('#example1').DataTable({
		 "ajax"		: {
	    	  "url"		: "<%=request.getContextPath()%>/shuju_1.shtml",
	    	  "method"	: "POST",
	    	  "headers" : {"Content-Type": "application/json"},
	    	  "data"	: function(d){
	    		  return JSON.stringify(d);
	    	  }
	      },
	      "columns": [
	    	  {"data": "office",
	    	 "defaultContent": "1"},
	    	  {"data":"startTime"},
	    	  {"data":"stopTime"},
	    	  {"data":"zt"},
	    	  {"data": function(data, type, row) { return '<button onclick="pop()" type="button" class="btn btn-primary btn-lg results" data-toggle="modal" data-target="#myModal2" data-whatever="@jason" style="width: 70px;height: 20px;font-size: 10px;line-height: 0px">查看结果</button>'; } },
	      ],
	      
	});
		t.on('order.dt search.dt',
		  function() {
   		       t.column(0, {
   		              search: 'applied',
   		              order: 'applied',
   		        }).nodes().each(function(cell, i) {
   		              cell.innerHTML = i + 1;
   		  	  
   		  	   })        	 	
   		  	   }).draw();	
		$("#xuanzhe").change(function(){
<<<<<<< HEAD
			
			var id=$(this).val();
			//alert(id);
			 $.ajax({
  			   type: "POST",
  			   url: "user_shuju1_1.shtml?id="+id,
  				success:function(message){
  					var $tianjia;
  					$("#guanxibiao span:first").remove();
  					$("#guanxibiao span:first").remove();
  					$("#guanxizhiduan span:first").remove();
  					$("#guanxizhiduan span:first").remove();
  					 var mess=eval("("+message+")");
  					 //alert(mess);
  					//var me=mess[0].tableinfoslist[0].name;
  					//alert(mess.length);
  					//var me=mess[0];
  					// alert(me);
  					 for(var i=0;i<mess.length;i++){
  						var me=mess[i].tableinfoslist;
  						var me1=mess[i].Weidulielist;
  						//alert(me);
  						//alert(me1);
  						for(var j=0;j<me.length;j++){
  							
  							var m=me[j].name;
  							var m1=me1[j].lie_name;
  							//alert(m);
  							//alert(m1);
  							$tianjia=$("<span id='jj'>"+me[j].name+"、</span>");
  							$("#guanxibiao").append($tianjia);
  							$("#guanxizhiduan").append("<span>"+me[j].name+"."+me1[j].lie_name+"、</span>")
  						}
  						
  					 } 
=======
			var id=$(this).val();
			alert(id);
			 $.ajax({
  			   type: "POST",
  			   url: "user_shuju1_2.shtml?id="+id,
  				success:function(message){
  					
>>>>>>> refs/remotes/origin/master
  				},
  				error:function(){
  					 alert(XMLHttpRequest.status);
  				   alert(XMLHttpRequest.readyState);
  				   alert(textStatus);
  				}
			 })	   
		})
	
  })
</script>
<script type="text/javascript">
   	function pop(){
   	  $(".results").attr("data-toggle","modal");
      $(".results").attr("data-target","#myModal")
      $(".results").attr("id","identifier");
      $('#myModal').modal({
        show:false,
        backdrop:"static",
        keyboard:false
   	})
   	}
    
</script>
