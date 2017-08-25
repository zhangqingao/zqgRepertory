<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- page script -->
<script>
  $(function () {
	var t =	$('#example1').DataTable({
		 "ajax"		: {
	    	  "url"		: "<%=request.getContextPath()%>/dt_list2.shtml",
	    	  "method"	: "POST",
	    	  "headers" : {"Content-Type": "application/json"},
	    	  "data"	: function(d){
	    		  return JSON.stringify(d);
	    	  }
	      },
	      "columns": [
	    	  {"data": "office",
	    	 "defaultContent": "1"},
	    	  {"data":"email"},
	    	  {"data":"name"},
	    	  {"data":"job"},
	    	  {"data":"phone"},
	    	  {"data": function(data, type, row) { return '<button type="button" class="btn btn-primary btn-lg delete_btn" data-toggle="modal" data-target="#myModal2" data-whatever="@jason" style="width: 70px;height: 20px;font-size: 10px;line-height: 0px" onclick="pop()">删除</button>'; } },
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
  })
  
  function pop(){
	 $.ajax({
		url:"",
		type:"",
		data:{},
		dataType:json,
		success:function(result){
			
		}
	 })
  }
  
</script>
<!-- <script type="text/javascript">
   	function pop(){
   	  $(".delete_btn").attr("data-toggle","modal");
      $(".delete_btn").attr("data-target","#myModal")
      $(".delete_btn").attr("id","identifier");
      $('#myModal').modal({
        show:false,
        backdrop:"static",
        keyboard:false
   	})
   	}
    
</script> -->




<%-- <script>
  $(function () {
    $('#example1').DataTable({
        "ajax"		: {
      	  "url"		: "<%=request.getContextPath()%>/dt_list2.shtml",
      	  "method"	: "POST",
      	  "headers" : {"Content-Type": "application/json"},
      	  "data"	: function(d){
      		  return JSON.stringify(d);
      	  }
        },
        "columns": [
      	  {"data":"id"},
      	  {"data":"name"},
      	  {"data":"email"},
      	  {"data":"phone"},
      	  {"data":"job"},
      	  {"data":"删除"}
        ]
    })
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script> --%>
 