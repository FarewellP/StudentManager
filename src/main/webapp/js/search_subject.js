﻿// 全局变量，总页数，当前页数
var countPages = 1;
var currentPage = 1;
var roleId;

// AJAX异步查询课程
$(function()
{
	$("#search_subject").click(function()
	{
		if ($("#search_type").val() != "stu_all" && $.trim($("#value").val()) == "")
			alert("请输入关键字。");
		else
		{
			// 获取角色ID
			roleId = getRoleId();
			// 查询总页数并赋值到全局变量中
			countPages = getCountPage();
			// 默认查询第一页数据
			showData(currentPage);
			// 根据当前页数构建分页按钮
			showPage(currentPage);
		}
	});
});

// 整体调用函数
function show(page)
{
	showData(page);
	showPage(page);
}

// 根据条件查询数据，并显示分页查询数据
function showData(page)
{
	var url = "";
	url += "/Student/SearchSubjectServlet?search_type=" + $("#search_type").val();
	url += "&value=" + encodeURI(encodeURI($("#value").val())) + "&page=" + page;
	$.post(url, null, function(rs)
	{
		$("#table>tbody>tr").not(":first").remove();
		var str = "";
		for ( var i = 0; i < rs.length; i++)
		{
			str = "<tr class='change' align='center'>";
			str += "<td>" + (i + 1) + "</td>";
			str += "<td>" + rs[i].id + "</td>";
			str += "<td>" + rs[i].name + "</td>";
			str += "<td>" + rs[i].type + "</td>";
			str += "<td>" + rs[i].times + "</td>";
			if (roleId == 1)
			{
				str += "<td><a href='/Student/EditSubjectServlet?sub_id=" + rs[i].id + "'>编辑</a> / ";
				str += "<a href='/Student/DeleteSubjectServlet?sub_id=" + rs[i].id + "'>删除</a></td>";
			}
			else
				str += "<td> &nbsp;/</td>";
			str += "</tr>";
			$("#table").append(str);
		}
	}, "json");
}

// 查询总页数,只返回一个总页数
function getCountPage()
{
	var url = "", rt = "";
	url += "/Student/GetSubjectCountPageServlet?search_type=" + $("#search_type").val();
	url += "&value=" + encodeURI(encodeURI($("#value").val()));
	$.ajax(
	{
		type : "post",
		url : url,
		async : false, // 设置成同步，不然回调函数无法按正确顺序执行
		dataType : "text",
		success : function(rs)
		{
			rt = rs;
		}
	});
	return rt;
}

// 构建分页按钮链接组件
function showPage(page)
{
	$("#center>p,#center>br").remove();
	var str = "<br/><p>";

	if (page <= 1)
		str += "<a class='a_3'>LastPage</a>";
	else
		str += "<a class='a_3' href='###' onclick='javascript:show(" + (page - 1) + ")'>LastPage</a>";

	for ( var i = 1; i <= countPages; i++)
	{
		if (i == page)
			str += "<a class='a_4 select'>" + i + "</a>";
		else
			str += "<a class='a_4' href='###' onclick='javascript:show(" + i + ")'>" + i + "</a>";
	}

	if (page >= countPages)
		str += "<a class='a_3'>NextPage</a>";
	else
		str += "<a class='a_3' href='###' onclick='javascript:show(" + (page + 1) + ")'>NextPage</a>";

	$("#center").append(str);
}

// 获取当前登录的用户的角色ID，用来判断是否提供修改链接
function getRoleId()
{
	var rol_id;
	var url = "/Student/LoginServlet?type=get_rol_id";
	$.ajax(
	{
		type : "post",
		url : url,
		async : false,
		dataType : "text",
		success : function(rs)
		{
			rol_id = rs;
		}
	});
	return rol_id;
	//return 2;
}