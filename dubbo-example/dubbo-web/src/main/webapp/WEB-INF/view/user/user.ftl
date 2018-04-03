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
<div class="container">
    <div id="toolbar">
        <div class="form-inline" role="form">
            <div class="form-group">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createModel">新增</button>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary">修改</button>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary">删除</button>
            </div>
        </div>
    </div>
    <table id="table" data-toggle="table" data-url="${ctx}/user/get/data"
           data-side-pagination="server"
           data-pagination="true"
           data-page-list="[5, 10, 20, 50, 100, 200]">
        <thead>
        <tr>
            <th data-checkbox="true"></th>
            <th data-field="name">用户名</th>
            <th data-field="password">密码</th>
            <th data-field="salt">盐值</th>
            <th data-field="note">备注</th>
            <th data-field="state">状态</th>
        </tr>
        </thead>
    </table>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="createModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    创建用户
                </h4>
            </div>
            <div class="modal-body">
                <form role="form" id="createForm">
                    <div class="form-group-sm">
                        <label for="name">用户名</label>
                        <input type="text" class="form-control" name="name" placeholder="请输入名称">
                    </div>
                    <div class="form-group">
                        <label for="name">密码</label>
                        <input type="text" class="form-control" name="password" placeholder="请输入名称">
                    </div>
                    <div class="form-group">
                        <label for="name">盐值</label>
                        <input type="text" class="form-control" name="salt" placeholder="请输入名称">
                    </div>
                    <div class="form-group">
                        <label for="name">备注</label>
                        <input type="text" class="form-control" name="note" placeholder="请输入名称">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="createUser()">
                    创建
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="${ctx}/static/plugins/jquery/jquery-3.2.1.js"></script>
<script src="${ctx}/static/plugins/jquery/jquery.form.js"></script>
<script src="${ctx}/static/plugins/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/static/plugins/bootstrap-dialog/js/bootstrap-dialog.js"></script>
<script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${ctx}/static/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    var $table = $('#table');

    function createUser() {
        // **序列化中文以及字符时会出现乱码，是因为.serialize()调用了encodeURLComponent方法将数据编码了**
        // **解决方法：**调用decodeURIComponent(XXX,true);将数据解码
        var form_data = $('#createForm').serialize();
        var submitData=decodeURIComponent(form_data,true);
        $.ajax({
            url: '${ctx}/user/create',
            data: submitData,
            cache:false,    //false是不缓存，true为缓存
            async:true,     //true为异步，false为同步
            beforeSend:function(){
                //请求前
            },
            success:function (result) {  //请求成功时
                // console.log(result);
                $('#createModel').modal('hide'); //隐藏
                $table.bootstrapTable('refresh', {url: '${ctx}/user/get/data'});

            },
            complete:function(){
                //请求结束时
            },
            error:function(){
                //请求失败时
            }
        });
    }
</script>
</body>
</html>