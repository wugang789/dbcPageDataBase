<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<a href="view?currentPage=2">ss</a>


</div>
<table>
 <tr><td>id</td><td>姓名</td><td>爱好</td></tr>
<c:forEach items="${mylist}" var="list">
<tr>
<td>${list.id}</td>
<td>${list.studentName }</td>
<td>${list.hobby}</td>
</tr>
</c:forEach>
</table>
	<div>
                               总记录数：${count}&nbsp; 当前页数:${index}/${pageCount }&nbsp;&nbsp; 
          <a href="view?index=1">首页</a>| 
          <a href="view?index=${index==1?index:(index-1)}">上一页</a>|
		  <a href="view?index=${index==pageCount?index:index+1 }">下一页</a>|
			<a href="view?index=${pageCount}">尾页</a>&nbsp;
			跳到第 <select id="select" onchange="go()">
				<option>请选择</option>
				<c:forEach begin="1" end="${pageCount}" var="p">
					<option value="${p}">${p}</option>
				</c:forEach>
			</select> 页
		</div>
</body>
</html>