
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.entity.items.Items,com.dao.itemsdao.ItemsDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情</title>
<style type="text/css">
div {
	float: left;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 5px;
	margin-bottom: 5px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

 dd.dd_name {
	color: blue;
}

 dd.dd_city {
	color: #000;
}
</style>
</head>
<body>
	<h1>商品详情</h1>
	<hr>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<!-- 商品详情 -->
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					Items item = new Items();
					ItemsDao itemsDao = new ItemsDao();
					item = itemsDao.getSingleItems(id);
				%>
				<td width="70%" valign="top">
					<%-- <table>
						<tr>
							<td rowspan="1"><img src="images/<%=item.getPicture()%>"
								width="200" height="160"></td>
						</tr>
						<tr>
							<td><B><%=item.getName()%></B></td>
						</tr>
						<tr>
							<td>产地:<%=item.getCity()%></td>
						</tr>
						<tr>
							<td>价格:<%=item.getPrice()%>￥
							</td>
						</tr>
					</table> --%>
					<dl>
						<dt>
							<img src="images/<%=item.getPicture()%>" width="200" height="160">
						</dt>
						<dd class="dd_name">
							<b><%=item.getName()%></b>
						</dd>
						<dd class="dd_city">
							产地:<%=item.getCity()%>&nbsp;&nbsp;价格:<%=item.getPrice()%>￥</dd>
					</dl>
				</td>
				<!-- 浏览过的商品 -->
				<td width="30%" bgcolor="#EEE" align="center"><br> <b>您浏览过的商品</b><br>
					<!-- 循环开始 --> <%
 	Cookie[] cookies = request.getCookies();
 	String s = "";
 	for (Cookie cookie : cookies) {
 		if ("itemcookie".equals(cookie.getName())) {
 			s = cookie.getValue();
 		}
 	}
 	s += request.getParameter("id") + ",";
 	Cookie itemCookie = new Cookie("itemcookie", s);
 	response.addCookie(itemCookie);
 %> <%
 	ArrayList<Items> list = itemsDao.getLatestFive(s);
 	if (list != null && list.size() > 0) {
 		for (Items i : list) {
 %>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=i.getId()%>"><img
									src="images/<%=i.getPicture()%>" width="120" height="90"
									border="1"></a>
							</dt>
							<dd class="dd_name"><%=i.getName()%></dd>
							<dd class="dd_city">
								产地:<%=i.getCity()%>&nbsp;&nbsp;价格:<%=i.getPrice()%>￥
							</dd>
						</dl>
					</div> <!-- 循环结束 --> <%
 	}
 	}
 %></td>
			</tr>
		</table>
	</center>
</body>
</html>