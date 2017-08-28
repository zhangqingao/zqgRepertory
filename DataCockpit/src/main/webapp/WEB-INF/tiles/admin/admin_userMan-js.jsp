<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  $(function () {
   var t = $('#example1').DataTable({
		 "ajax"		: {
	    	  "url"		: "<%=request.getContextPath()%>/dt_lists4.shtml",
	    	  "method"	: "POST",
	    	  "headers" : {"Content-Type": "application/json"},
	    	  "data"	: function(d){
	    		  return JSON.stringify(d);
	    	  }
	      },
	      "columns" :[
	    	  {"data": "office","defaultContent": "1"},
	    	  {"data":"phone"},
	    	  {"data":"corpname"},
	    	  {"data":"name"},
	    	  {"data":"job"},
	    	  {"data":"email"},                  
	                  ],
	      "columnDefs": [	                     
					{
	    		    "targets": 6,
	    		    /* "data": "title", */
	    		    "render": function ( data, type, row, meta ) {
	    		    /* 将当前值传入controller */	  
	    		     return '<a href="./admin_userDsh.shtml" class="button button-primary button-rounded button-small" style="font-size: 14px;">编辑</a>';   		    		
	    		    }
	    		  },
					{
	 	    		    "targets": 7,
	 	    		    /* "data": "title", */
	 	    		    "render": function ( data, type, row, meta ) {
	 	    		    /* 将当前值传入controller */	  
	 	    		    /*  <button class="button button-3d button-action button-circle button-jumbo"  ><i class="fa fa-thumbs-up">编辑</i></button> */
	 	    		     return '<select><option>已启用</option><option>已禁用</option></select>';	 	    		    				 	    		     
	 	    		    }
	 	    		  }
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
</script>
<!-- <script language="jscript"> 
	function ee() { if(confirm("请确认是否通过?" )) return true; return false;  }
	function dd() { if(confirm("请确认是否不通过?" )) return true; return false;  }
</script>  -->