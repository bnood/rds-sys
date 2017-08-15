<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 工具栏 -->
<div id="ItemToolbar"  style="padding:5px;height:auto">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true" onclick="javascript:Item.list.add()">增加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" plain="true" onclick="javascript:Item.list.delete()">删除</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true" onclick="javascript:Item.list.edit()">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" plain="true" onclick="javascript:Item.list.reload()">刷新</a>
    <span style="float: right;margin-right: 10px;padding: 1px">
        <span>用户名:</span>
        <input lang="searchItem" name="filter['name']" style="line-height:19px;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" plain="true" onclick="javascript:Item.list.clear()">清除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="javascript:Item.list.search()">搜索</a>
    </span>
</div>
<div class="easyui-panel" data-options="width:'100%',minHeight:600,border:false">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false">
            <!-- 列表 -->
            <table id="ItemList" data-options="border:false" style="width: 100%;" title="用户"></table>
        </div>
    </div>
</div>
<!-- 弹窗  --> <!-- inline:true 不然多次打开tab会重复提交表单 -->
<div id="ItemEdit" title="用户"  style="width:500px;top: 50px;padding: 10px;display: none" data-options="iconCls: 'icon-save',closed: true,modal: true,inline:true,buttons:[{text:'保存',iconCls:'icon-save',handler:function(){Item.input.submitForm()}},{text:'取消',iconCls:'icon-cancel',handler:function(){Item.input.close()}}]"></div>
<script src="<%=request.getContextPath()%>/jsp/biz/demo/demo.js"></script>
<script>
    Item.list.init('<%=request.getContextPath()%>');
</script>