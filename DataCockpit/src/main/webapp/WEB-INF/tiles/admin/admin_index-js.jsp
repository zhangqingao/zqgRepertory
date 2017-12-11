<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  $(function () {
    $('#example1').DataTable()
//     $('#example2').DataTable({
//       'paging'      : true,
//       'lengthChange': false,
//       'searching'   : false,
//       'ordering'    : true,
//       'info'        : true,
//       'autoWidth'   : false
      
      
//     })
    var t = $('#example2').DataTable({
    	
    	  'paging'      : true,
          'lengthChange': false,
          'searching'   : false,
          'ordering'    : true,
          'info'        : true,
          'autoWidth'   : false,
          
		 "ajax"		: {
	    	  "url"		: "<%=request.getContextPath()%>/dt_lists5.shtml",
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
	    		    /*  <button class="button button-3d button-action button-circle button-jumbo"  ><i class="fa fa-thumbs-up">编辑</i></button> */

	    		     return '<a href="./adminuss_updatee.shtml?id='+row.id+'" onclick="return ee();" class="button button-primary button-rounded button-small" style="font-size: 14px;">通过</a>\
	    		    		&emsp;\
	    		    		<a href="./adminus_delete.shtml?id='+row.id+'" onclick="return dd();" class="button button-primary button-rounded button-small" style="font-size: 14px;">不通过</a>'	 ;	}}    		    			

	    		  
	      ],	      
	});
		
  });

</script>
