<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script src="js/echarts.min.js" type="text/javascript"></script>
<%--		<script type="text/javascript">--%>
<%--			import * as echarts from 'echarts';--%>
<%--			// 基于准备好的dom，初始化echarts实例--%>
<%--			var myChart = echarts.init(document.getElementById('bar'));--%>

<%--			// 指定图表的配置项和数据--%>
<%--			var option = {--%>
<%--				title: {--%>
<%--					text: 'ECharts 入门示例'--%>
<%--				},--%>
<%--				tooltip: {},--%>
<%--				legend: {--%>
<%--					data:['销量']--%>
<%--				},--%>
<%--				xAxis: {--%>
<%--					data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]--%>
<%--				},--%>
<%--				yAxis: {},--%>
<%--				series: [{--%>
<%--					name: '销量',--%>
<%--					type: 'bar',--%>
<%--					data: [5, 20, 36, 10, 10, 20]--%>
<%--				}]--%>
<%--			};--%>

<%--			// 使用刚指定的配置项和数据显示图表。--%>
<%--			myChart.setOption(option);--%>
<%--		</script>--%>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>welcome page</title>
		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
body {
	margin: 50px 20px auto 20px;
	background: url(../images/body-bg.png) repeat;
}
</style>
	</head>
	<body>
		<center>
			<h2>欢迎进入学生信息管理系统！</h2>
			<br/>
			<hr/>
			<strong>
			<br/>
			<h3>学生信息管理系统简介</h3><br/>
			<div style="width:700px;text-align: left" >	
				<p>　　本项目是采用JSP技术（JSP+Servlet+JavaBean+MySQL）开发一个简单的高校学生管理</p><br/>
				<p>WEB版软件。高校学生管理系统围绕学生进行信息化管理。包括学生的基本信息、学生学习情</p><br />
				<p>况及成绩信息。</p><br/>
				<p>　　学生进入学校学习后，需要建立个人档案信息，并需要分专业、班级进行学习。而学校</p><br/>
				<p>各专业均有自己的教学体系及相应的学习课程。需要安排教师进行日常的教学活动。学生修</p><br/>
				<p>完规定的学习任务与相应的学分后方可毕业。本项目就是对上述业务进行网络信息化管理。</p><br/>
				<p>　　另外，为了使软件能正常有序地运行，需要管理员在软件后台对各操作员进行权限管理</p><br>
				<p>与控制。</p>
			</div>
			</strong>
		</center>
	<div class="e-section section-course white-box">
		<div class="section-header clearfix">
			<div id="bar" style="width: 600px;height: 600px;float: left"></div>
<%--			<div id="pei" style="width: 600px;height: 600px;float: left"></div>--%>
<%--			<div id="line" style="width: 600px;height: 600px;float: left"></div>--%>
<%--			<div id="bar1" style="width: 600px;height: 600px;float: left"></div>--%>
		</div>
	</div>
	</body>
</html>
