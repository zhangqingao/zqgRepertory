<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
            $("#check_1 tr").find("td:eq(3)").css("text-align","center");
              $("#check_1 tr").find("td:eq(3)").mouseenter(function(){
              $(this).css("cursor","pointer");
              });
</script>
<script type="text/javascript">
 
    $("#check_1 tr").find("td:eq(3)").find(".uploads").children().click(function(){  
     
    $("#check_1 tr").find("td:eq(3)").find(".uploads").children().attr("data-toggle","modal");
    $("#check_1 tr").find("td:eq(3)").find(".uploads").children().attr("data-target","#myModal")
    $("#check_1 tr").find("td:eq(3)").find(".uploads").children().attr("id","identifier");
    $('#myModal').modal({
      show:false,
      backdrop:"static",
      keyboard:false

    }); 
  });

    
</script>
<script type="text/javascript">
$(".close").click(function(){
      $("#upfile").val("");

});
$("button[data-dismiss=modal]").click(function(){
      $("#upfile").val("");

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