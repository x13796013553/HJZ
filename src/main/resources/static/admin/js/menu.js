


function addParentMenu() {
    //弹出即全屏
    var index = layer.open({
        type: 2,
        title:"新增",
        content: '/menu/addMenu',
        area: ['500px', '500px'],
        maxmin: true
    });
    layer.full(index);
}