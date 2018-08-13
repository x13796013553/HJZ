/**
 * Created by Administrator on 2017/8/25.
 */
// 配置扩展方法路径
layui.config({
    base: '/static/admin/frame/static/js/'   // 模块目录
}).extend({                         // 模块别名
    vip_nav: 'vip_nav'
    , vip_tab: 'vip_tab'
    , vip_table: 'vip_table'
});


// 退出登录
function loginOut(){
    layer.confirm('确认退出吗？', {
        btn: ['是','否'] //按钮
    }, function(){
        $.ajax({
            url:"/loginOut",
            type:"post",
            success:function (data) {
                if(data.status == "1"){
                    window.location.href="/admin";
                }else{
                    layer.msg(data.msg);
                    return false;
                }
            }
        });
    });
}

