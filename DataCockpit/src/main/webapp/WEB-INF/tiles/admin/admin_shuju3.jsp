<%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        碧桂园房地产开发有限公司
        <small>销售到访关联</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            

          <div class="box">
            <div class="box-header">
              <h3 class="box-title" style="color: red">数据分析任务列表</h3> 
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>任务开始时间</th>
                  <th>任务结束时间</th>
                  <th>任务状态</th>
                  <th>任务反馈</th>                
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>1</td>
                  <td>2017-06-01 12:12:22</td>
                  <td>2017-06-01 15:12:22</td>
                  <td>任务完成</td>
                  <td><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" data-whatever="@jason" style="width: 70px;height: 20px;font-size: 10px;line-height: 0px">查看结果</button></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>2017-06-11 12:12:22</td>
                  <td>2017-06-11 18:12:22</td>
                  <td>任务失败</td>
                  <td><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal1" style="width: 100px;height: 20px;font-size: 10px;line-height: 0px">查看出错信息</button></td>
                </tr>
                 <tr>
                  <td>3</td>
                  <td>2017-06-21 12:12:22</td>
                  <td></td>
                  <td>任务进行中</td>
                  <td><a href="#"></a></td>
                </tr>
                 <tr>
                  <td>4</td>
                  <td>2017-06-21 15:12:22</td>
                  <td></td>
                  <td>任务已添加</td>
                  <td><a href="#"></a></td>
                </tr>
                </tbody>
              </table>
<div class="modal fade bs-example-modal-sm" id="myModal1" role="dialog" aria-label="myModalLabel" aria-hidden="true">  
    <div class="modal-dialog modal-sm" style="width: 40%">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
                    <span aria-hidden="true">×</span>  
                </button>  
                <h4 class="modal-title">任务执行出错</h4>  
            </div>  
            <div class="modal-body">  
                <form>  
                    <div class="form-group">  
                        <label class="control-label">出错原因为：</label>  
                        abcdefafdasfasdfaasdfasdfasdfasdfasdfasdfasdfewrqerqwfdsafdassfdasd当任务失败时，任务反馈的字段中存放的不是任务反馈id，而是任务的出错信息。可在点选出错信息后，直接展示。fasdfasdfasfdsafasewqrqwreafdasfdfdasfdasdfasdfasdfasdf  
                    </div>      
                </form>  
            </div>  
            <div class="modal-footer">  
                <button type="button" class="btn btn-default" data-dismiss="modal">  
                    关闭  
                </button>  
                <!-- <button type="button" class="btn btn-primary">  
                    保存  
                </button>   -->
                </div>
            </div> 
        </div>  
    </div>  
</div> 
 

<div class="modal fade bs-example-modal-sm" id="myModal2" role="dialog" aria-label="myModalLabel" aria-hidden="true">  
    <div class="modal-dialog modal-sm" style="width: 40%">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
                    <span aria-hidden="true">×</span>  
                </button>  
                <h4 class="modal-title">信息如下</h4>  
            </div>  
            <div class="modal-body">  
                <form>  
                    <div class="form-group">  
                        <table width="100%" border="1px" cellspacing="0px" cellpadding="0px" id="tb">
                          <tr>
                            <td>编号</td>
                            <td>推理规则</td>
                            <td>结论</td>
                          </tr>
                          <tr>
                            <td>1</td>
                            <td>(A>6,B<3)</td>
                            <td>C>=12</td>
                          </tr>                          
                          <tr>
                            <td>2</td>
                            <td>(C>6,F<1)</td>
                            <td>E<=42</td>
                          </tr>
                        </table> 
                    </div>  
                    <div class="form-group">  
                        <label class="control-label">备注：</label>  
                        任务反馈中存放的是反馈结果id，通过调用一个借口，以反馈结果id为参数，获得一个二维的String数组（例如{["编号","推理规则"，"结论"],["1","(A > 6,B < 3)","C>=12"],["2","(C >6,F < 1)","E<=42"]}），第一行是表头，后续每行都是结果值。点击"下载计算结果"，则当前表格被输出到CSV文件中，弹出文件保存对话框。
                    <hr><button type="button" style="width: 100px;height: 20px;font-size: 10px;line-height: 0px">下载计算结果</button>                    
                </form>  
            </div>  
            <div class="modal-footer">  
                <button type="button" class="btn btn-default" data-dismiss="modal">  
                    关闭  
                </button>  
                <!-- <button type="button" class="btn btn-primary">  
                    保存  
                </button>   -->
                </div>
            </div> 
        </div>  
    </div>  
</div>  
<!--end modal2-->  
          
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->