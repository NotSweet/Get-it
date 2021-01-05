<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
			<li><strong><a
					href="${pageContext.request.contextPath }/task_find.action">主页</a>
			</strong>
			</li>
			<li><strong><a
					href="${pageContext.request.contextPath }/task_hist.action">历史</a>
			</strong>
			</li>
			<li><strong><a href="pay.jsp">充值</a> </strong>
			</li>
			<li><strong><a href="pay.jsp">设置</a> </strong>
			</li>
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

						</div></td>

					<td class="mui--text-title">校园帮</td>
					<td align="right">
						<ul class="mui-list--inline mui--text-body2">

							<li><a
								href="${pageContext.request.contextPath }/task_find.action">${loginUser.username}</a>,欢迎您
							</li>
							<li><a href="login.jsp">退出</a></li>
							<li><a href="#">关于</a></li>
						</ul>
					</td>
				</tr>
			</table>
		</div>

	</header>
	<div id="content-wrapper">
		<div class="mui--appbar-height"></div>
		<div class="mui-container-fluid">
			<div style="text-align:center;">
			<div class="mui-panel" style="margin-top:20px;padding-top:50px;padding-bottom:50px;" >
				<span class="mui--text-dark mui--text-headline">任务发布</span>
				
				<br>
				<form class="mui-form" action="${pageContext.request.contextPath }/task_send.action" method="post">

					<div class="mui-textfield mui-textfield--float-label" style="width:500px;margin:0 auto;text-align:left">
						<input type="text" name="title"> <label>标题</label>
					</div>
					<br>
					<div class="mui-textfield mui-textfield--float-label" style="width:500px;margin:0 auto;text-align:left">
						<input type="text" name="content"> <label>简要信息 如:出发地,目的地</label>
					</div>
					<br>
					<div class="mui-textfield mui-textfield--float-label" style="width:500px;margin:0 auto;text-align:left">
						<input type="text" name="address"> <label>详细内容 如:宿舍号等信息</label>
					</div>
					<br>
					<div class="mui-textfield mui-textfield--float-label" style="width:500px;margin:0 auto;text-align:left">
						<input type="text" name="phone_number"> <label>手机号</label>
					</div>
					<br>
					<div class="mui-textfield mui-textfield--float-label" style="width:500px;margin:0 auto;text-align:left">
						<input type="text" name="score"> <label>积分数</label>
					</div>
					<br>
					<div class="mui--text-accent mui--text-subhead" style="width:500px;margin:0 auto;text-align:left">
					<label><input name="radio" type="radio" value="1"  checked="checked"/>悬赏</label> 
					<label><input name="radio" type="radio" value="2" />招标</label> 
					</div>
					<br>
					<button type="submit" class="mui-btn mui-btn--primary">发布</button>
				</form>


			</div>

			</div>





		</div>
	</div>
	<footer>

		<div class="mui-container mui--text-center">
			制作 ♥ <a href="#">科技</a>
		</div>
	</footer>

</body>
</html>