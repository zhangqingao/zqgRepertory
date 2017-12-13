<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
Date.prototype.Format = function(fmt) { //author: meizz 
    var o = { 
        "M+": this.getMonth() + 1, 
        //月份 
        "d+": this.getDate(), 
        //日 
        "h+": this.getHours(), 
        //小时 
        "m+": this.getMinutes(), 
        //分 
        "s+": this.getSeconds(), 
        //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), 
        //季度 
        "S": this.getMilliseconds() //毫秒 
    }; 
    if (/(y+)/.test(fmt)) { 
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
    } 
    for (var k in o) { 
        if (new RegExp("(" + k + ")").test(fmt)) { 
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length))); 
        } 
    } 
    return fmt; 
} 
</script>
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
	   		 //{"data":"publishDate"},
	   		 
	                  ], 

		  "columnDefs": [	 
			 	{
				"targets": 3,
			    "mData": "publishDate", 
				"render" : function(data, type, row, meta) {  
				//时间格式化  
				//var time =new  data.Format("yyyy-MM-dd hh:mm:ss"); 
			   return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss"); ;
				
						     		 
					   } 
				},
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
