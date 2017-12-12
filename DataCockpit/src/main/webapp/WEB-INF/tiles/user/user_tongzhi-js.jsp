<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
          
              $("#check_1 tr").find("td:eq(0)").css("width","100px")
              $("#check_1 tr").find("td:eq(0)").css("text-align","center")
              
              $("#check_1 tr").find("td:eq(1)").css("width","500px")
            
              $("#check_1 tr").find("td:eq(2)").css("text-align","center")     
              $("#check_1 tr").find("td:eq(2)").mouseenter(function(){
                $(this).css("cursor","pointer");
              });
            
              $("#check_1 tr").find("td:eq(1)").mouseenter(function(){
                $(this).css("cursor","pointer");
              });
              $("#check_1 tr").find("td:eq(1)").click(function(){
              	window.location.href="./#"
              })
            </script>
            
           <!-- <script type="text/javascript">
          		function pop1(data, type, row){
          			console.log(row);
          			var title=$("title").val();
          			var a =$("publisher").val();
          			window.location.href="./admin_tongzhi3.shtml?title="+title+"&publisher="+publisher;
          		}
           </script> -->
           
<script type="text/javascript">
   
    $("#check_1 tr").find("td:eq(4)").click(function(){    
    $("#check_1 tr").find("td:eq(4)").attr("data-toggle","modal");
    $("#check_1 tr").find("td:eq(4)").attr("data-target","#myModal")
    $("#check_1 tr").find("td:eq(4)").attr("id","identifier");
    $('#myModal').modal({
      show:false,
      backdrop:"static",
      keyboard:false
   	 }    
    ); 
     });
  
</script>
<script>



  $(function () {
	
	var t =	$('#example1').DataTable({
		 "ajax"		: {
	    	  "url"		: "<%=request.getContextPath()%>/dt_lists3.shtml",
	    	  "method"	: "POST",
	    	  "headers" : {"Content-Type": "application/json"},
	    	  "data"	: function(d){
	    		  return JSON.stringify(d);
	    	  }
	      },
	      "columns" :[
	    	  {"data": "office","defaultContent": "1" },
	    	  {"data":"title"},
	    	  {"data":"details"}, 
	   		  {"data":"publishDate"},
	    	  /*  "render" : function(data, type, full, meta) {  
                  //时间格式化  
                  return  moment(publishDate).format("YYYY-MM-DD");   
              }   */
	    	/*   {
                  "targets": 3,
                  "mData": "publishDate", 
				   "render" : function(data, type, full, meta) {  
				         //时间格式化  
				         return  moment(mData).format("YYYY-MM-DD");  
       				}
                 }    
	                  ], */
	            
	                 /*   "aoColumns": [	 
					 	{
					    "targets": 3,
					     "mData": "publishDate", 
					     "render" : function(data, type, full, meta) {  
					         //时间格式化  
					         return  moment(mData).format("YYYY-MM-DD");  
					     } 
					 	},*/
						]  
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

<!-- <script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1')
    //bootstrap WYSIHTML5 - text editor
    $('.textarea').wysihtml5()
  })
</script> -->
