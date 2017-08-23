<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<script type="text/javascript">
              $("#check_1 tr").find("td:eq(4)").css("text-align","center")
              $("#check_1 tr").find("td:eq(4)").mouseenter(function(){
                $(this).css("cursor","pointer");
              });
 </script>
<script>
  $(function () {
	$('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false,
      "processing"	: true,
      "serverSide"	: true,
    
    })
  })
</script>