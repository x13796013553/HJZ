jQuery(document).ready(function () {

    /*
        Background slideshow
    */
    $.backstretch([
        "/static/admin/login/img/1.jpg"
        , "/static/admin/login/img/2.jpg"
        , "/static/admin/login/img/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    // 绑定密码的input框的keydown事件
    $('#password').keydown(function(e){
        if(e.keyCode == 13){
        	submitLogin();
        }
    });

});

// 提交登录表单
function submitLogin() {
    // 验证用户名和密码格式
    var username = $("#username").val();
    var password = $("#password").val();

    var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (!uPattern.test(username)) {
        $.alert("用户名不符合规范，请重新输入");
        $("#username").focus();
        return false;
    } else {
        if (password == "" || password == null) {
        	$.alert("密码不能为空");
            $("#password").focus();
            return false;
        }
    }

    $.ajax({
        url: "login/checkUser",
        type: "post",
        data: {
            username: username,
            password: password
        },
        success: function (data) {
            if (data == "1") {
                window.location.href = "/admin";
            } else {
                console.log(data);
                $.alert("登录失败！！");
            }
        }
    })

}



