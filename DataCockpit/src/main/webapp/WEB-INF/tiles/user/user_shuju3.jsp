<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        ××××数据平台
        <!-- <small>advanced tables</small> -->
      </h1>
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard"></i>最近一次的更新时间</li>
        <li>2017-04-22</li>
        <li>15:20:33</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          
          <!-- /.box -->
          

          <div class="box">
          
          
            <div class="box-header" style="width: 180px">
              <h3 class="box-title">数据分析任务列表</h3>
            </div>
            <div id="uploads" style="margin-left: 180px;margin-top: -35px"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" data-whatever="@jason" style="width: 100px;height: 30px;font-size: 14px;line-height: 0px">上传新数据</button></div>

            <div style="margin-left: 300px;margin-top: -29.7px"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" data-whatever="@jason" style="width: 100px;height: 30px;font-size: 14px;line-height: 0px">导出数据</button></div>
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>项目名称</th>
                  <th>所在区域</th>
                  <th>日期</th>
                  <th class="people_nums">到访人数</th>
                  <th class="people_nums">认筹人数</th>
                  <th>退订人数</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>1</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>湖北武汉XXX有限公司 </td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>5</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>6</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>7</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>8</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                <tr>
                  <td>9</td>
                  <td>湖北武汉XXX有限公司</td>
                  <td>湖北武汉XXX地区</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>12</td>
                  <td>13</td>
                  <td>9</td>
                </tr>
                </tbody>
                
              </table>

                 <!-- Main content -->
 
      
        <div id="line-tu" class="col-md-6"  style="margin-top: -380px;margin-left: -999px">
          <!-- AREA CHART -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">曲线关系图</h3>

              <div class="box-tools pull-right">
                
                <button id="area-close" type="button" class="btn btn-box-tool"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="areaChart" style="height:250px"></canvas>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col (LEFT) -->

      <div id="bar-tu" class="col-md-6" style="margin-top: -30px;margin-left: -999px">
          <!-- AREA CHART -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">条形统计图</h3>

              <div class="box-tools pull-right">
                
                <button id="bar-close" type="button" class="btn btn-box-tool"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="bar-chart" style="height: 300px;"></div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      <!-- /.col (LEFT) -->
          
    </div>
            <!-- /.box-body -->
           
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="height:60%">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               信息显示
            </h4>
         </div>
         
         <div class="modal-body">
         <center>
            <input type="text" size="20" name="upfile" id="upfile" style="border:1px dotted #ccc">  

            <input type="button" value="浏览" onclick="path.click()" style="border:1px solid #ccc;background:#fff">  
            <input type="file" id="path" style="display:none" onchange="upfile.value=this.value">
         </center>   
    


         </div>

         <div class="modal-footer">
            <button type="button" class="btn btn-default"
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               下载计算结果
            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal_1" tabindex="-1" role="dialog"
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="height:60%">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel_1">
               信息显示
            </h4>
         </div>
         
         <div class="modal-body">
         <center>
            <textarea id="text-area" cols="70" rows="10" ></textarea>
         </center>   
    


         </div>

         <div class="modal-footer">
            <button type="button" class="btn btn-default"
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               确定
            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




