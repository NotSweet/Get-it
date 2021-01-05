<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>

<html>



<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="mui-0.9.27/css/mui.min.css" rel="stylesheet" type="text/css" />
<link href="mui-0.9.27/static/style.css" rel="stylesheet"
	type="text/css" />
<script src="mui-0.9.27/js/mui.min.js"></script>
<script src="mui-0.9.27/js/jquery-2.1.4.min.js"></script>
<script src="mui-0.9.27/static/script.js"></script>
</head>


<body>

	<div id="sidedrawer" class="mui--no-user-select">
		<div id="sidedrawer-brand" class="mui--appbar-line-height">

			<img width="90" height="90" style="margin-top:20px"
				src="img/ico_1.png" /> <br>
			<div class="mui--text-headline">${loginUser.sno}</div>
			<div class="mui--text-subhead">河北科技师范学院</div>

		</div>

		<div class="mui-divider"></div>
		<ul>
			<li><strong><a href="${pageContext.request.contextPath }/task_find.action">主页</a>
			</strong></li>
			<li><strong><a href="${pageContext.request.contextPath }/task_hist.action">历史</a>
			</strong></li>
			<li><strong><a href="pay.jsp">充值</a>
			</strong></li>
			<li><strong><a href="pay.jsp">设置</a>
			</strong></li>
		</ul>
	</div>
	<header id="header">



		<div class="mui-appbar mui--appbar-line-height">


			<table width="95%">


				<tr class="mui--appbar-height">
					<td><div class="mui-container-fluid">
							<a
								class="sidedrawer-toggle mui--visible-xs-inline-block mui--visible-sm-inline-block js-show-sidedrawer">☰</a>
							<a
								class="sidedrawer-toggle mui--hidden-xs mui--hidden-sm js-hide-sidedrawer">☰</a>

						</div>
					</td>

					<td class="mui--text-title">校园帮&nbsp; &nbsp;&nbsp;&nbsp;<a href="send.jsp">发布</a></td>
					<td align="right">
						<ul class="mui-list--inline mui--text-body2">

							<li><a
								href="${pageContext.request.contextPath }/task_find.action">${loginUser.username}</a>,欢迎您
							</li>
							<li><a href="login.jsp">退出</a>
							</li>
							<li><a href="#">关于</a>
							</li>
						</ul></td>
				</tr>
			</table>
		</div>

	</header>
	<div id="content-wrapper">
		<div class="mui--appbar-height"></div>
		<div class="mui-container-fluid">
			<table class="mui-table">

				<tbody>
				<thead>

					<tr>
						<th><div
								class="mui--text-accent-secondary mui--text-display1"
								style="text-align:center;margin-top:20px;">悬赏任务</div></th>
						<th><div
								class="mui--text-accent-secondary mui--text-display1"
								style="text-align:center;margin-top:20px;">招标任务</div></th>
					</tr>

				</thead>

				<s:iterator value="result">
					<tr>
						<td width="50%"><div class="mui-panel">
								<div>
									<img width="70" height="70" src="img/ico_1.png"
										style="float:left; margin-right:20px" /> <a
										class="mui--text-dark mui--text-headline"><s:property
											value="title" />
									</a>

									<div class="mui--text-dark mui--text-subhead"><s:property
											value="content" /></div>
								</div>
								<br> &nbsp<a class="mui--text-accent mui--text-body1"><s:property
											value="username" /></a>·
								悬赏：<span class="mui--text-accent mui--text-body1"><s:property
											value="score" /></span> <span
									style="float:right;" class="mui--text-accent mui--text-body1"><s:property
											value="create_time" /></span>
							</div></td>
						<!-- <td width="50%"><div class="mui-panel">
						 	<div>
									<img width="70" height="70" src="img/ico_1.png"
										style="float:left; margin-right:20px" /> <a
										class="mui--text-dark mui--text-headline"><s:property
											value="title" /></a>

									<div class="mui--text-dark mui--text-subhead">buhuuh</div>
								</div>
								<br> &nbsp<a class="mui--text-accent mui--text-body1">Body1</a>·
								悬赏：<span class="mui--text-accent mui--text-body1">123</span> <span
									style="float:right;" class="mui--text-accent mui--text-body1">20:3920</span>
							</div>
							
							</td>-->



					</tr>
				</s:iterator>


				</tbody>
			</table>


		</div>
	</div>
	<footer>

		<div class="mui-container mui--text-center">
			制作 ♥ <a href="#">科技</a>
		</div>
	</footer>

</body>
</html>