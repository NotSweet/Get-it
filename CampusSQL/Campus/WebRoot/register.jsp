<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>

<style>

/**
 * Body CSS
 */
html,body {
	height: 100%;
}

html,body,input,textarea,button {
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.004);
}

/**
 * Header CSS
 */
header {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	z-index: 2;
}

header ul.mui-list--inline {
	margin-bottom: 0;
}

header a {
	color: white;
}

#content-form {
	width: 60%;
	text-align: left;
	align: center;
	margin: 0 auto;
}

/**
 * Content CSS
 */
#content-wrapper {
	background-color: #E8E8E7;
	min-height: 100%;
	/* sticky footer */
	box-sizing: border-box;
	margin-bottom: -100px;
	padding-bottom: 100px;
}

/**
 * Footer CSS
 */
footer {
	box-sizing: border-box;
	height: 100px;
	background-color: #eee;
	border-top: 1px solid #e0e0e0;
	padding-top: 35px;
}
</style>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="mui-0.9.27/css/mui.min.css" rel="stylesheet" type="text/css" />
<script src="mui-0.9.27/js/mui.min.js"></script>
</head>
<body>
	<header class="mui-appbar mui--z1">
		<div class="mui-container">
			<table width="100%">
				<tr class="mui--appbar-height">
					<td class="mui--text-title"><a href="index.jsp">校园帮</a></td>
					<td align="right">
						<ul class="mui-list--inline mui--text-body2">
							<li><a href="#">关于</a>
							</li>

							<li><a href="#">登陆</a>
							</li>
						</ul></td>
				</tr>
			</table>
		</div>
	</header>



	<div id="content-wrapper" class="mui--text-center">
		<div class="mui--appbar-height"></div>
		<br> <br>
		<div id="content-form" class="mui-panel">
			<div class="mui--text-display1" align="center">用户注册</div>
			<br> <br>

			<form class="mui-form" action="${pageContext.request.contextPath }/user_register.action" method="post">

				<div class="mui-textfield mui-textfield--float-label">
					<input type="text" name="username"> <label>请输入用户名</label>
				</div>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="password" name="password"> <label>请输入密码</label>
				</div>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="password"> <label>再次输入密码</label>
				</div>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="text"  name="sno"> <label>请输入学号</label>
				</div>
				<div class="mui-textfield mui-textfield--float-label">
					<input type="text" name="phonenumber"> <label>手机号</label>
				</div>


				<button type="submit" class="mui-btn mui-btn--primary"
					style="width:100%">确定</button>

			</form>
		</div>

	</div>

	<footer>

		<div class="mui-container mui--text-center">
			制作 ♥  <a href="#">科技</a>
		</div>
	</footer>
</body>
</html>