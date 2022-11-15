<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    pageContext.setAttribute("baseHref", request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/");
    pageContext.setAttribute("contextPath", request.getContextPath());%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${pageScope.baseHref}">
    <meta charset="UTF-8">
    <title>用户登陆页面</title>
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function forSubmit() {
            let loginAct = $.trim($('#loginAct').val());
            let loginPwd = $.trim($('#loginPwd').val());
            let $msg = $('#msg');

            if (loginAct === null || loginAct === '' ||
                loginPwd === null || loginPwd === '') {
                $msg.html('账号或密码为空！');
            } else {
                $.ajax({
                    url : '${contextPath}/settings/user/login',
                    type : 'POST',
                    data : 'loginAct=' + loginAct +
                        '&loginPwd=' + loginPwd,
                    async : true,
                    dataType : 'json',
                    success : function (ajaxStr) {
                        console.log(ajaxStr);
                        let json_ajaxStr = eval(ajaxStr);
                        if (json_ajaxStr.success) {
                            window.location.href = '${contextPath}/workbench/index';
                        } else {
                            $msg.html(json_ajaxStr.errorMsg);
                        }
                    }
                });
            }
        }

        $(function () {
            if (window.top !== window) {
                window.top.location = window.location;
            }

            let $input = $(':input');
            // 自动获得焦点
            $input[0].focus();

            // 回车
            $input.keydown(function (event) {
                if (event.keyCode === 13) {
                    forSubmit();
                }
            })
            // 按钮
            $('.btn').click(forSubmit);
        });
    </script>
</head>
<body>
    <div style="position: absolute; top: 0; left: 0; width: 60%;">
        <img src="image/IMG_7114.jpg" style="width: 100%; height: 90%; position: relative; top: 50px;" alt="pic">
    </div>
    <div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
        <div style="position: absolute; top: 5px; left: 0; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman',serif">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
    </div>

    <div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
        <div style="position: absolute; top: 0; right: 60px;">
            <div class="page-header">
                <h1>登陆</h1>
            </div>
            <form action="workbench/index.html" class="form-horizontal" role="form">
                <div class="form-group form-group-lg">
                    <div style="width: 350px;">
                        <input class="form-control" type="text" placeholder="用户名" id="loginAct">
                    </div>
                    <div style="width: 350px; position: relative;top: 20px;">
                        <input class="form-control" type="password" placeholder="密码" id="loginPwd">
                    </div>
                    <div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
                        <span style="color: red" id="msg">${requestScope.error}</span>
                    </div>
                    <%--
                        按钮写在表单中，默认就是提交表单
                        不要移动位置，将按钮类型改变为button，通过js来决定接下来的功能
                    --%>
                    <button type="button" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;" id="loginBtn">登录</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
