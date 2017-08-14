<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="ItemForm" method="post">
    <div class="com_table" align="center">
        <input type="hidden" name="id">
        <div>
            <label>登录名:</label>
            <div>
                <input class="easyui-textbox com_input" type="text" name="loginName" data-options="required:true"/>
            </div>
        </div>
        <div>
            <label>用户名:</label>
            <div>
                <input class="easyui-textbox com_input" type="text" name="name" data-options="required:true"/>
            </div>
        </div>
        <div>
            <label>密码:</label>
            <div>
                <input class="easyui-textbox com_input" type="text" name="password" data-options="required:true"/>
            </div>
        </div>
        <div>
            <label>性别:</label>
            <div>
                <select class="easyui-combobox" name="sex" data-options="panelHeight:'auto',value:'0'"
                        style="width:260px;">
                    <option value="0">男</option>
                    <option value="1">女</option>
                </select>
            </div>
        </div>
        <div>
            <label>年龄:</label>
            <div>
                <input class="easyui-textbox com_input" type="text" name="age" data-options="required:false"/>
            </div>
        </div>
        <div>
            <label>手机号:</label>
            <div>
                <input class="easyui-textbox com_input" type="text" name="phone" data-options="required:false"/>
            </div>
        </div>
        <div>
            <label>用户类别:</label>
            <div>
                <select class="easyui-combobox" name="userType" data-options="panelHeight:'auto',value:'0'"
                        style="width:260px;">
                    <option value="0">用户</option>
                    <option value="1">管理员</option>
                </select>
            </div>
        </div>
        <div>
            <label>用户状态:</label>
            <div>
                <select class="easyui-combobox" name="status" data-options="panelHeight:'auto',value:'0'"
                        style="width:260px;">
                    <option value="0">启用</option>
                    <option value="1">停用</option>
                </select>
            </div>
        </div>
    </div>
</form>
<script src="<%=request.getContextPath()%>/jsp/biz/demo/demo.js"></script>
<script>
    Item.input.init('<%=request.getContextPath()%>');
</script>
