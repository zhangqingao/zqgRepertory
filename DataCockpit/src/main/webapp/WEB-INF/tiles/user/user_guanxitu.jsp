<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       数据关联关系
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <ul>
			<li><input type="button" class="choose" value="销售数据表" style="background:#f56954"></li>
			<li><input type="button" class="choose" value="到访数据表" style="background:#f39c12"></li>
			<li><input type="button" class="choose" value="轮班数据表" style="background:#00a65a"></li>
			<li><input type="button" class="choose" value="派单数据表" style="background:#605ca8"></li>
			<li><input type="button" class="choose" value="认筹数据表" style="background:#d81b60"></li>
			<li><input type="button" class="choose" value="中介数据表" style="background:#39cccc"></li>
			<li><input type="button" class="choose" value="媒体渠道数据表" style="background:#3c8dbc"></li>
		</ul>      
		<div id="paper" class="paper"></div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
