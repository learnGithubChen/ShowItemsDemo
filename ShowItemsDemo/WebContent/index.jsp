<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.itemsdao.ItemsDao,com.entity.items.Items"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>展示商品</title>
<style type="text/css">
div {
	float: left;
	margin: 10px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: black;
}
</style>
</head>
<body>
	<h1>商品展示</h1>
	<hr>
	<center>
		<table width="750" height="120" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<td>
					<!-- 商品循环展示 --> <%
 	ItemsDao itemsDao = new ItemsDao();
 	ArrayList<Items> list = new ArrayList<Items>();
 	list = itemsDao.getAllItems();
 	if (list != null && list.size() > 0) {
 		for (int i = 0; i < list.size(); i++) {
 %>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=list.get(i).getId()%>"><img
									src="images/<%=list.get(i).getPicture()%>" width="120"
									height="90"></a>
							</dt>
							<dd class="dd_name"><%=list.get(i).getName()%></dd>
							<dd class="dd_city">
								产地:<%=list.get(i).getCity()%>&nbsp;&nbsp;价格:<%=list.get(i).getPrice()%></dd>
						</dl>
					</div> <!-- 商品循环结束 --> <%
 	}
 	}
 %>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>