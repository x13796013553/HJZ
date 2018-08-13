// 树菜单转换方法
function convert(rows) {//默认三级  List集合
    // 返回true：是父菜单  返回false：不是父菜单
    function exists(row) {
        if (row.parentId == 0) {
            return true;
        } else {
            return false;
        }

    }

    var nodes = [];
    // get the top level nodes
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        if (exists(row) == true) {
            nodes.push({
                id: row.classId,
                spread: true,
                name: row.className + "(" + row.classId + ")" + "<a style='width:40px;font-size:12px;' href=\"javascript:editParentData('" + row.classId + "');\" >编辑</a>" + "<a style='width:40px;font-size:12px;' href=\"javascript:deleteParentData('" + row.classId + "');\" >删除</a>",
                parent: null
            });
        }
    }

    // var toDo = [];
    // for (var i = 0; i < nodes.length; i++) {
    //     toDo.push(nodes[i]);
    // }

    // 二级菜单
    for (var j = 0; j < nodes.length; j++) {

        for (var k = 0; k < rows.length; k++) {
            var row = rows[k];

            if (parseInt(nodes[j].id) == parseInt(row.parentId)) {
                var child = {
                    id: row.classId,
                    spread: true,
                    name: row.className + "(" + row.classId + ")" + "<a style='width:40px;font-size:12px;' href='javascript:editParentData(" + row.classId + ");' >编辑</a>" + "<a style='width:40px;font-size:12px;' href='javascript:deleteParentData(" + row.classId + ");' >删除</a>",
                    parentId: nodes[j].id,
                    parentName: nodes[j].name
                };

                if (nodes[j].children) {
                    nodes[j].children.push(child);
                } else {
                    nodes[j].children = [child];
                }


            }
        }
    }

    // 三级菜单
    for (var l = 0; l < nodes.length; l++) {
        if (nodes[l].children) {
            for (var m = 0; m < nodes[l].children.length; m++) {

                var sec = nodes[l].children;

                for (var n = 0; n < rows.length; n++) {
                    var row = rows[n];

                    if (parseInt(sec[m].id) == parseInt(row.parentId)) {
                        var child = {
                            id: row.classId,
                            spread: true,
                            name: row.className + "(" + row.classId + ")" + "<a style='width:40px;font-size:12px;' href='javascript:editParentData(" + row.classId + ");' >编辑</a>" + "<a style='width:40px;font-size:12px;' href='javascript:deleteParentData(" + row.classId + ");' >删除</a>",
                            parentId: sec[m].id,
                            parentName: sec[m].name
                        };

                        if (sec[m].children) {
                            sec[m].children.push(child);
                        } else {
                            sec[m].children = [child];
                        }
                    }
                }
            }
        }

    }

    return nodes;
}

// 时间格式化
function toDate(v) {
    var date = new Date();
    date.setTime(v.time);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? '0' + m : m;
    var s = date.getSeconds();
    var d = date.getDate();
    d = d < 10 ? ("0" + d) : d;
    var h = date.getHours();
    h = h < 10 ? ("0" + h) : h;
    var M = date.getMinutes();
    M = M < 10 ? ("0" + M) : M;
    var S = date.getSeconds();
    S = S < 10 ? ("0" + S) : s;
    var str = y + "-" + m + "-" + d;
    return str;
}