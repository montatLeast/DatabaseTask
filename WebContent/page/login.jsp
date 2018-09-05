<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0"> 
	<title>咨询管理系统</title>
    <link href="../css/default.css" rel="stylesheet" type="text/css" />
	<!--必要样式-->
    <link href="../css/styles.css" rel="stylesheet" type="text/css" />
    <link href="../css/demo.css" rel="stylesheet" type="text/css" />
    <link href="../css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class='login'>
	  <div class='login_title'>
	    <span>用户登录</span>
	  </div>
 <form method="post" action="/DatabaseTask/LoginServlet?method=login"  onsubmit=" return test()">
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='../img/user_icon_copy.png'>
	      </div>
	      <input type="text" id="account"  name="account" placeholder='账号' maxlength="20" type='text' autocomplete="off" />
	        <div class='validation'>
	          <img alt="" src='../img/tick.png'>
	        </div>
	        
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='../img/lock_icon_copy.png'>
	      </div>
	      <input type="password" id="password" name="password" placeholder='密码' maxlength="20" type='text' autocomplete="off" />
	      <div class='validation'>
	        <img alt="" src='../img/tick.png'>
	      </div>
	    </div>
	             <p></p>
	                         <p></p>

	    <div class='login_fields__submit'>
	      <input type='submit' value='登录'>
	    </div>
	    </form>
	  </div>
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p>欢迎登录就业咨询管理系统</p>
	  </div>
	</div>
	<div class='authent'>
	  <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
        </div>
	</div>

</body>
</html>
