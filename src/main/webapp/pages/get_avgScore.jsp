<%@ page contentType="text/html; charset=utf-8" language="java"
		 import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>search page</title>
	<link href="../css/search.css" rel="stylesheet" type="text/css" />
	<script src="../js/jquery-1.8.3.min.js" type="text/javascript">
	</script>
	<script src="../js/getAvg.js" type="text/javascript">
	</script>
	<script src="../js/search.js" type="text/javascript">
	</script>
</head>

<body>
<center>
	<div class="window">
		<div class="searchbox tit">
			查找课程：
			<select id="search_type">
				<c:choose>
					<c:when test="${sessionScope.log_operator.role.id == 3}">
						<option value="stu_all">
							查找全部
						</option>
					</c:when>
					<c:otherwise>
						<option value="stu_all">
							查找全部
						</option>
					</c:otherwise>
				</c:choose>
			</select>
			<input id="getAvg" type="button" value="  查询  " />
		</div>

		<center id="center">
			<table id="table" width="700px" border="1px" cellspacing="0"
				   cellpadding="5" bordercolor="#999999">
				<tr align="center">
					<td width="50px">
						编号
					</td>
					<td width="100px">
						课程ID
					</td>
					<td width="200px">
						课程名
					</td>
					<td width="100px">
						平均成绩
					</td>
				</tr>
			</table>
		</center>
	</div>
</center>
</body>
</html>