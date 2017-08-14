var ctx = "";//项目部署的工程名
var ItemList;
var ItemEdit;
var ItemForm;

var Item = {
    URL: {
        inputUI: function () {
            return ctx + "/demo/ui/input";
        },
        list: function () {
            return ctx + "/demo/";
        },
        save: function () {
            return ctx + "/demo/";
        },
        delete: function (ids) {
            return ctx + "/demo/" + ids;
        },
        get: function (id) {
            return ctx + "/demo/" + id;
        },
    },
    input: {
        init: function (ct) {
            ctx = ct;
            Item.input.initComponent();
            Item.input.initForm();
        },
        initComponent: function () {
            ItemForm = $("#ItemForm");
        },
        initForm: function () {
            ItemForm.form({
                url: Item.URL.save(),
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');
                    if (data.code == 200) {
                        Item.input.close();
                        Item.list.reload();
                    }
                }
            });
        },
        submitForm: function () {
            // submit the form
            ItemForm.submit();
        },
        close: function () {
            ItemEdit.dialog('close');
        }
    },
    list: {
        init: function (ct) {
            ctx = ct;
            Item.list.initComponent();
            Item.list.initList();
        },
        initComponent: function () {
            ItemList = $("#ItemList");
            ItemEdit = $('#ItemEdit');
        },
        initList: function () {
            ItemList.datagrid({
                url: Item.URL.list(),
                method: 'get',
                pagination: true,
                pageSize: 30,
                toolbar: '#ItemToolbar',//Item.list.toolbar,
                singleSelect: false,
                collapsible: false,
                columns: [[
                    {field: 'ck', checkbox: true},
                    {field: 'id', title: '主键id', hidden: true},
                    {field: 'loginName', title: '登录名', width: '8.636%', hidden: false},
                    {field: 'name', title: '用户名', width: '8.636%', hidden: false},
                    {field: 'password', title: '密码', width: '8.636%', hidden: true},
                    {field: 'sex', title: '性别', width: '8.636%', hidden: false,formatter:function(value,row,index){return value==0?'男':'女';}},
                    {field: 'age', title: '年龄', width: '8.636%', hidden: false},
                    {field: 'phone', title: '手机号', width: '8.636%', hidden: false},
                    {field: 'userType', title: '用户类别', width: '8.636%', hidden: false,formatter:function(value,row,index){return value==0?'用户':'管理员';}},
                    {field: 'status', title: '用户状态', width: '8.636%', hidden: false,formatter:function(value,row,index){return value==0?'启用':'停用';}},
                    {field: 'updateTime', title: '更新时间', width: '10%', hidden: false},
                    {field: 'createTime', title: '创建时间', width: '10%', hidden: false},
                ]],
                //设置选中事件，清除之前的行选择
                onClickRow: function (index,row) {
                    ItemList.datagrid("unselectAll");
                    ItemList.datagrid("selectRow",index);
                },
            });
        },
        getSelectionsIds: function () {
            var sels = ItemList.datagrid("getSelections");
            var ids = [];
            for (var i in sels) {
                ids.push(sels[i].id);
            }
            ids = ids.join(",");
            return ids;
        },
        //增
        add: function () {
            ItemEdit.dialog({
                    href: Item.URL.inputUI(),
                })
                .dialog("open");
        },
        //改
        edit: function () {
            var sels = ItemList.datagrid("getSelections");
            if (sels.length < 1) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            if (sels.length > 1) {
                $.messager.alert("对话框", "只能选择一行");
                return;
            }

            ItemEdit.dialog({
                    href: Item.URL.inputUI(),
                    onLoad: function () {
                        //方案一：使用Form的load去load数据
                        //ItemForm.form("load", Item.URL.get(sels[0].id));
                        //方案二：直接使用列表的row数据
                        //ItemForm.form("load",sels[0]);
                        //方案三：使用Ajax请求数据
                        $.ajax({
                            type: "GET",
                            url: Item.URL.get(sels[0].id),
                            success: function (data) {
                                if (data.code == 200) {
                                    ItemForm.form("load", data.data);
                                }
                            }
                        });
                    }
                })
                .dialog("open");
        },
        //删
        delete: function () {
            var ids = Item.list.getSelectionsIds();
            if (ids.length == 0) {
                $.messager.alert("对话框", "至少选择一行");
                return;
            }

            $.messager.confirm({
                title: '确认提示框',
                msg: '你确定要删除吗？',
                fn: function (r) {
                    if (r) {
                        $.ajax({
                            type: "DELETE",
                            url: Item.URL.delete(ids),
                            success: function () {
                                Item.list.reload();
                                Item.list.clearSelectionsAndChecked();
                            }
                        });
                    }
                }
            });
        },
        //刷新
        reload: function () {
            ItemList.datagrid("reload");
        },
        clearSelectionsAndChecked:function(){
            ItemList.datagrid("clearChecked");
            ItemList.datagrid("clearSelections");
        },
        //搜索
        search: function () {
            var searchName = [];
            var searchValue = [];
            $("input[lang='searchItem']").each(function (i) {
                searchName[i] = $(this).attr("name");
                searchValue[i] = $(this).val();
            });

            var queryParamsArr = [];
            for (var i = 0; i < searchName.length; i++) {
                queryParamsArr.push('"'+searchName[i] + '":"' + searchValue[i] + '"')
            }
            var queryParams = "{" + queryParamsArr.join(",") + "}";

            ItemList.datagrid({
                queryParams: eval('(' + queryParams + ')'),
                onLoadSuccess: function (data) {
                    //回显搜索内容
                    $("input[lang='searchItem']").each(function (i) {
                        $(this).val(searchValue[i]);
                    });
                }
            });
        },
        //清空
        clear: function () {
            $("input[lang='searchItem']").each(function (i) {
                $(this).val("");
            });
        }
    }
}
