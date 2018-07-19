<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/body.css"/>
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/js/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/admin/login" method="post">
            <h1>登录</h1>
            <div>
                <input type="text" placeholder="账号" required="" id="loginName" name="loginName"/>
            </div>
            <div>
                <input type="password" placeholder="密码" required="" id="loginPwd" name="loginPwd"/>
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
            </div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="button" value="登录" class="btn btn-primary" id="loginBtn"/>
                <a href="#">忘记密码?</a>
                <!-- <a href="#">Register</a> -->
            </div>
        </form><!-- form -->

    </section><!-- content -->
</div>
<script>
    $(function () {
        $("#loginBtn").click(function () {

            $.ajax({
                type: "post",
                url: "admin/login",
                dataType: "json",
                timeout: 30000,
                data: {loginName: $("#loginName").val(), loginPwd: $("#loginPwd").val()},
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.alert(errorThrown);
                },
                success: function (data) {
                    layer.msg('加载中', {
                        icon: 16
                        ,shade: 0.01
                    });
                }
            })
        })
    })
</script>
</body>
</html>