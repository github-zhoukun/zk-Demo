<#assign ctx="${rc.contextPath}">
<html>
<head>
    <title>用户管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${ctx}/static/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/bootstrap-dialog/css/bootstrap-dialog.css" rel="stylesheet">
    <link href="${ctx}/static/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
</head>
<body>
<h1> 用户信息： </h1>
<table data-toggle="table" data-url="${ctx}/user/get/data"
       data-side-pagination="server"
       data-pagination="true"
       data-page-list="[5, 10, 20, 50, 100, 200]"
       data-search="true">
    <thead>
    <tr>
        <#--<th data-checkbox="true"></th>-->
        <th data-field="name">用户名</th>
        <th data-field="password">密码</th>
        <th data-field="salt">盐值</th>
        <th data-field="note">备注</th>
        <th data-field="state">状态</th>
    </tr>
    </thead>
</table>

<script src="${ctx}/static/plugins/jquery/jquery-3.2.1.js"></script>
<script src="${ctx}/static/plugins/jquery/jquery.form.js"></script>
<script src="${ctx}/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/static/plugins/bootstrap-dialog/js/bootstrap-dialog.js"></script>
<script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${ctx}/static/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</body>
</html>