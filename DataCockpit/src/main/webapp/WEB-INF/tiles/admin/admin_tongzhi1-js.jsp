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
              $(".editor-1").click(function(){
            	  window.location.href="./admin_tongzhi3.shtml"
              })
            </script>
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
	$('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })

</script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1')
    //bootstrap WYSIHTML5 - text editor
    $('.textarea').wysihtml5()
  })
</script>