<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'news_index.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<%@include file="/jsp/public/commons.jspf"%>

	</head>

	<body>
		<form action="" method="post">
			<table>
				<thead>
					<tr>
						<th>
							<input type="checkbox">
						</th>
						<th>
							编号
						</th>
						<th>
							标题
						</th>
						<th>
							作者
						</th>
						<th>
							时间
						</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty pm.list}">
						<c:forEach items="${pm.list}" var="news" varStatus="i">
							<tr>
								<td>
									<input type="checkbox">
								</td>
								<td>
									${pm.offset+i.index+1 }
								</td>
								<td>
									<a href="javascript:;" onclick="window.location.href='<%=request.getContextPath() %>/news.do?method=getOne&id=${news.id }'">${news.title }</a>
								</td>
								<td>
									${news.author.username }
								</td>
								<td>
									${news.datetime }
								</td>
								<td>
									<a href="javascript:;">修改</a>&nbsp;&nbsp;
									<a href="javascript:;">删除</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty pm.list}">
						<tr>
							<td colspan="6">
								没有记录
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="6">
							<input type="button" value="添加"
								onclick="window.location.href='<%=request.getContextPath()%>/jsp/news_add.jsp'" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
<pg:pager url="news.do"   items="${pm.total}" export="currentPageNumber=pageNumber" >
<pg:first><a href="${pageUrl }">首页</a></pg:first>
<pg:prev><a href="${pageUrl }">上一页</a></pg:prev>
<pg:pages>
<c:choose>
<c:when test="${pageNumber eq currentPageNumber}">${pageNumber }</c:when>
<c:otherwise><a href="${pageUrl }">${pageNumber }</a></c:otherwise>
</c:choose>
</pg:pages>
<pg:next><a href="${pageUrl }">下一页</a></pg:next>
<pg:last><a href="${pageUrl }">尾页</a></pg:last>
</pg:pager>
	</body>
</html>
