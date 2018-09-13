$(function () {
    $("#loginBtn").click(function () {

        var account = $("#account").val();
        var password = $("#password").val();
        if (account == "" || account == null) {
            layer.msg("账号不能为空！");
            return;
        }
        if (password == null || password == "") {
            layer.msg("密码不能为空！");
            return;
        }
        $.ajax({
            type: "post",
            url: "admin/login",
            dataType: "json",
            timeout: 30000,
            data: {account: account, password: password},
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(errorThrown);
            },
            success: function (data) {
                layer.msg('加载中', {
                    icon: 16
                    , shade: 0.01
                });
            }
        })
    })
})