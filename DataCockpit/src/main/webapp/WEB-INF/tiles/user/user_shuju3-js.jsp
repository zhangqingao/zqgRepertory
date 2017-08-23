<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
   
    $("#uploads").click(function(){    
    $("#uploads").attr("data-toggle","modal");
    $("#uploads").attr("data-target","#myModal")
    $("#uploads").attr("id","identifier");
    $('#myModal').modal({
      show:false,
      backdrop:"static",
      keyboard:false
    }
    
    ); 
     });
  
</script>
<script type="text/javascript">
             $(".people_nums").click(function(){
                $("#line-tu").css("margin-left","230px");

             });
             $("#area-close").click(function(){
                  $("#line-tu").css("margin-left","-999px");
             });
 </script>
   <script type="text/javascript">
              $("tbody tr").mouseenter(function(){
              $(this).css("cursor","pointer");
             $("tbody tr").click(function(){
              $(this).css("color","blue");
              $("tbody tr").not($(this)).removeAttr("style");

             })
              });
 </script>

<script type="text/javascript">
             $(".people_nums").click(function(){
                $("#bar-tu").css("margin-left","230px");

             });
             $("#bar-close").click(function(){
                  $("#bar-tu").css("margin-left","-999px");
             });
</script>
<script type="text/javascript">
   
    $("tbody tr").click(function(){    
    $("tbody tr").attr("data-toggle","modal");
    $("tbody tr").attr("data-target","#myModal_1")
    $("tbody tr").attr("id","identifier_1");
    $('#myModal_1').modal({
      show:false,
      backdrop:"static",
      keyboard:false
    }
    
    ); 
     });
  
</script>


<script type="text/javascript">
$(".close").click(function(){
      $("#text-area").val("");

});
$("button[data-dismiss=modal]").click(function(){
      $("#text-area").val("");

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
    "use strict";
    
    //BAR CHART
    var bar = new Morris.Bar({
      element: 'bar-chart',
      resize: true,
      data: [
        {y: '2006', a: 100, b: 90},
        {y: '2007', a: 75, b: 65},
        {y: '2008', a: 50, b: 40},
        {y: '2009', a: 75, b: 65},
        {y: '2010', a: 50, b: 40},
        {y: '2011', a: 75, b: 65},
        {y: '2012', a: 100, b: 90}
      ],
      barColors: ['#00a65a', '#f56954'],
      xkey: 'y',
      ykeys: ['a', 'b'],
      labels: ['CPU', 'DISK'],
      hideHover: 'auto'
    });
  });
</script>
<script>
  $(function () {
    

    // Get context with jQuery - using jQuery's .get() method.
    var areaChartCanvas = $('#areaChart').get(0).getContext('2d')
    // This will get the first returned node in the jQuery collection.
    var areaChart       = new Chart(areaChartCanvas)

    var areaChartData = {
      labels  : ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
      
        {
          label               : 'Digital Goods',
          fillColor           : 'rgba(60,141,188,0.9)',
          strokeColor         : 'rgba(60,141,188,0.8)',
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [50, 11, 22, 19, 86, 27, 90]
        }
      ]
    }

    var areaChartOptions = {
      //Boolean - If we should show the scale at all
      showScale               : true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines      : false,
      //String - Colour of the grid lines
      scaleGridLineColor      : 'rgba(0,0,0,.05)',
      //Number - Width of the grid lines
      scaleGridLineWidth      : 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines  : true,
      //Boolean - Whether the line is curved between points
      bezierCurve             : true,
      //Number - Tension of the bezier curve between points
      bezierCurveTension      : 0.3,
      //Boolean - Whether to show a dot for each point
      pointDot                : false,
      //Number - Radius of each point dot in pixels
      pointDotRadius          : 4,
      //Number - Pixel width of point dot stroke
      pointDotStrokeWidth     : 1,
      //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
      pointHitDetectionRadius : 20,
      //Boolean - Whether to show a stroke for datasets
      datasetStroke           : true,
      //Number - Pixel width of dataset stroke
      datasetStrokeWidth      : 2,
      //Boolean - Whether to fill the dataset with a color
      datasetFill             : true,      
      //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio     : true,
      //Boolean - whether to make the chart responsive to window resizing
      responsive              : true
    }
    areaChartOptions.datasetFill = false
    //Create the line chart
    areaChart.Line(areaChartData, areaChartOptions)

    
  })
</script>
