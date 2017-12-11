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
	    	  {"data":"state"},
	    	  
	                  ],
	                 
	          
	      "columnDefs": [	 
// 						{
// 						    "targets": 6,
// 						     "data": "state", 
// 						    "render": function ( data, type, row, meta ) {
						      
// 						     return '<span>'+date+'</span>'   ;		    		
// 						    }
// 						  },
					{
	    		    "targets": 7,
	    		    /* "data": "title", */
	    		    "render": function ( data, type, row, meta ) {
	    		    /* 将当前值传入controller */	  
	    		     return '<a href="./aduser_update.shtml?id='+row.id+'" class="button button-primary button-rounded button-small" style="font-size: 10.5px;font-weight: bolder; ">编辑</a>';   		    		
	    		    }
	    		  },
					{
	 	    		    "targets": 8,
	 	    		    /* "data": "title", */
	 	    		    "render": function ( data, type, row, meta ) {
	 	    		    /* 将当前值传入controller */	  
	 	    		    /* <button class="button button-3d button-action button-circle button-jumbo"  ><i class="fa fa-thumbs-up">编辑</i></button> */
	 	    		     return '<a href="./aduser_update1.shtml?id='+row.id+'" onclick="return ee();" class="button button-primary button-rounded button-small" style="font-size: 10.5px;font-weight: bolder; ">启用</a>\
	    		    			\
	    		    			<a href="./aduser_update0.shtml?id='+row.id+'" onclick="return dd();" class="button button-primary button-rounded button-small" style="font-size: 10.5px;font-weight: bolder; ">禁用</a>';	 	    		    			    
	 	    		 }
	 	    	   }
<<<<<<< HEAD
	      ],
	      //在页面中修改datetables表格数据
	      "fnRowCallback" : function(nRow, aData, iDisplayIndex) {  
              /* 用来改写用户权限的 */  
              if (aData.state == '1')  
                  $('td:eq(6)', nRow).html('启用');  
              if (aData.state == '0')  
                  $('td:eq(6)', nRow).html('禁用');  
              
              return nRow;  
          },   
=======

	      ],	    
	          

	      //在页面中修改datetables表格数据
	      "fnRowCallback" : function(nRow, aData, iDisplayIndex) {  
              /* 用来改写用户权限的 */  
              if (aData.state == '1')  
                  $('td:eq(6)', nRow).html('启用');  
              if (aData.state == '0')  
                  $('td:eq(6)', nRow).html('禁用');  
              
              return nRow;  
          },   

>>>>>>> refs/remotes/origin/master
	      
	});
<<<<<<< HEAD
=======

//    var zt = $("#zt").html();
//    alert(zt);
//    if (zt==1) {
//        $("#zt").val("启用");
//    }else{
//  	  $("#zt").val("禁用");
//    }
			//alert("11");
			var i=dataTable.Rows[2][6].ToString(); 
			alert(i);
   
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
//    var oTable = $('#example1').dataTable();
//    oTable.fnUpdate( ['a', 'b', 'c', 'd', 'e','f','j'], 2 ); // Row


			
=======


//    var oTable = $('#example1').dataTable();
//    oTable.fnUpdate( ['a', 'b', 'c', 'd', 'e','f','j'], 2 ); // Row



>>>>>>> refs/remotes/origin/master
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
<script language="jscript"> 
	function ee() { if(confirm("请确认是否启用?" )) return true; return false;  }
	function dd() { if(confirm("请确认是否禁用?" )) return true; return false;  }
</script>
<script type="text/javascript">
function getTableContent(){  
	       var nTrs = table.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象  
	       for(var i = 0; i < nTrs.length; i++){  
	           console.log('[获取数据]' + table.fnGetData(nTrs[i]));//fnGetData获取一行的数据  
	           alert('[获取数据]' + table.fnGetData(nTrs[i]));
	       }  
	   }  

</script>
<!--

//-->
</script>
