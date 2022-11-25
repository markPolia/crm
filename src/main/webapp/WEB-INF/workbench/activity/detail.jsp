<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<% pageContext.setAttribute("base", request.getScheme() + "://" + request.getServerName()
		+ ":" + request.getServerPort() + request.getContextPath() + "/");
	pageContext.setAttribute("contextPath", request.getContextPath());%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>目标细节</title>
	<meta charset="UTF-8">
	<link href="${contextPath}/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${contextPath}/jquery/jquery-1.11.1-min.js"></script>
	<script type="text/javascript" src="${contextPath}/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		// 默认情况下取消和保存按钮是隐藏的
		let cancelAndSaveBtnDefault = true;

		// 删除备注
		function removeRemark(activityRemarkId) {
			$.ajax({
				url : '${contextPath}/workbench/activity/deleteRemarkById',
				data : {
					'activityRemarkId' : activityRemarkId
				},
				type : 'POST',
				dataType : 'JSON',
				async : false,
				success : function (json) {
					if (eval(json).success) {
						alert('删除成功！');
						// 刷新页面
						// showRemarkList();
						$('#' + activityRemarkId).remove();
					} else {
						alert('删除失败！');
					}
				}
			})
		}

		// 展示备注信息列表
		function showRemarkList() {
			$.ajax({
				url : '${contextPath}/workbench/activity/showRemarkListByAid',
				type : 'GET',
				dataType : 'JSON',
				data : {
					activityId : '${requestScope.aid}'
				},
				async : true,
				success : function (remarkAjaxStr) {
					let html = '';
					$.each(eval(remarkAjaxStr), function (index, element) {
						html += '<div id="' + element.id + '" class="remarkDiv" style="height: 60px;">' +
							'<img title="zhangsan" src="${contextPath}/image/user-thumbnail.png" style="width: 30px; height:30px;" alt="pic">' +
								'<div style="position: relative; top: -40px; left: 40px;" >' +
									'<h5>' + element.noteContent + '</h5>' +
									'<span style="color: gray; ">市场活动</span> <span style="color: gray; ">-</span> <b>${requestScope.name}</b> <small style="color: gray;"> ' + (element.editFlag === '1' ? element.editTime : element.createTime) + ' 由' + (element.editFlag === '1' ? element.editBy : element.createBy) + '</small>' +
									'<div style="position: relative; left: 500px; top: -30px; height: 30px; width: 100px; display: none;">' +
										'<a class="myHref" href="javascript:void(0);"><span class="glyphicon glyphicon-edit" style="font-size: 20px; color: #FF0000;"></span></a>' +
										'&nbsp;&nbsp;&nbsp;&nbsp;' +
											<%--
												javascript:void(0);
													禁用超链接，只能以触发事件的方式来进行操作
											--%>
										'<a class="myHref" href="javascript:void(0);" onclick="removeRemark(\'' + element.id + '\')"><span class="glyphicon glyphicon-remove" style="font-size: 20px; color: #FF0000;"></span></a>' +
									'</div>' +
								'</div>' +
						'</div>';
					});
					$('#remarkDiv').before(html);
				}
			});
		}

		$(function(){
			// 展现市场活动关联的备注信息列表
			showRemarkList();

			let $remarkBody = $("#remarkBody");
			$remarkBody.on("mouseover",".remarkDiv",function(){
				$(this).children("div").children("div").show();
			});
			$remarkBody.on("mouseout",".remarkDiv",function(){
				$(this).children("div").children("div").hide();
			});

			$("#remark").focus(function(){
				if(cancelAndSaveBtnDefault){
					//设置remarkDiv的高度为130px
					$("#remarkDiv").css("height","130px");
					//显示
					$("#cancelAndSaveBtn").show("2000");
					cancelAndSaveBtnDefault = false;
				}
			});

			$("#cancelBtn").click(function(){
				// 显示
				$("#cancelAndSaveBtn").hide();
				// 设置remarkDiv的高度为130px
				$("#remarkDiv").css("height","90px");
				cancelAndSaveBtnDefault = true;
			});

			let $remarkDiv = $(".remarkDiv");
			$remarkDiv.mouseover(function(){
				$(this).children("div").children("div").show();
			});

			$remarkDiv.mouseout(function(){
				$(this).children("div").children("div").hide();
			});

			let $myHref = $(".myHref");
			$myHref.mouseover(function(){
				$(this).children("span").css("color","red");
			});

			$myHref.mouseout(function(){
				$(this).children("span").css("color","#E6E6E6");
			});
		});
	</script>
</head>
<body>
	<!-- 返回按钮 -->
	<div style="position: relative; top: 35px; left: 10px;">
		<a href="javascript:void(0);" onclick="window.history.back();"><span class="glyphicon glyphicon-arrow-left" style="font-size: 20px; color: #DDDDDD"></span></a>
	</div>
	
	<!-- 大标题 -->
	<div style="position: relative; left: 40px; top: -30px;">
		<div class="page-header">
			<h3>市场活动-${requestScope.name} <small>${requestScope.startDate} ~ ${requestScope.endDate}</small></h3>
		</div>
		<div style="position: relative; height: 50px; width: 250px;  top: -72px; left: 700px;">
			<button type="button" class="btn btn-default" data-toggle="modal" data-target="#editActivityModal"><span class="glyphicon glyphicon-edit"></span> 编辑</button>
			<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
		</div>
	</div>
	
	<!-- 详细信息 -->
	<div style="position: relative; top: -70px;">
		<div style="position: relative; left: 40px; height: 30px;">
			<div style="width: 300px; color: gray;">所有者</div>
			<div style="width: 300px;position: relative; left: 200px; top: -20px;"><b>${requestScope.uname}</b></div>
			<div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">名称</div>
			<div style="width: 300px;position: relative; left: 650px; top: -60px;"><b>${requestScope.name}</b></div>
			<div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
			<div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
		</div>

		<div style="position: relative; left: 40px; height: 30px; top: 10px;">
			<div style="width: 300px; color: gray;">开始日期</div>
			<div style="width: 300px;position: relative; left: 200px; top: -20px;"><b>${requestScope.startDate}</b></div>
			<div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">结束日期</div>
			<div style="width: 300px;position: relative; left: 650px; top: -60px;"><b>${requestScope.endDate}</b></div>
			<div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
			<div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
		</div>
		<div style="position: relative; left: 40px; height: 30px; top: 20px;">
			<div style="width: 300px; color: gray;">成本</div>
			<div style="width: 300px;position: relative; left: 200px; top: -20px;"><b>${requestScope.cost}</b></div>
			<div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -20px;"></div>
		</div>
		<div style="position: relative; left: 40px; height: 30px; top: 30px;">
			<div style="width: 300px; color: gray;">创建者</div>
			<div style="width: 500px;position: relative; left: 200px; top: -20px;"><b>${requestScope.createBy}&nbsp;&nbsp;</b><small style="font-size: 10px; color: gray;">${requestScope.createTime}</small></div>
			<div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
		</div>
		<div style="position: relative; left: 40px; height: 30px; top: 40px;">
			<div style="width: 300px; color: gray;">修改者</div>
			<div style="width: 500px;position: relative; left: 200px; top: -20px;"><b>${requestScope.editBy}&nbsp;&nbsp;</b><small style="font-size: 10px; color: gray;">${requestScope.editTime}</small></div>
			<div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
		</div>
		<div style="position: relative; left: 40px; height: 30px; top: 50px;">
			<div style="width: 300px; color: gray;">描述</div>
			<div style="width: 630px;position: relative; left: 200px; top: -20px;">
				<b>
					${requestScope.description}
				</b>
			</div>
			<div style="height: 1px; width: 850px; background: #D5D5D5; position: relative; top: -20px;"></div>
		</div>
	</div>
	
	<!-- 备注 -->
	<div style="position: relative; top: 30px; left: 40px;" id="remarkBody">
		<div class="page-header">
			<h4>备注</h4>
		</div>

		<div id="remarkDiv" style="background-color: #E6E6E6; width: 870px; height: 90px;">
			<form role="form" style="position: relative;top: 10px; left: 10px;">
				<textarea id="remark" class="form-control" style="width: 850px; resize : none;" rows="2"  placeholder="添加备注..."></textarea>
				<p id="cancelAndSaveBtn" style="position: relative;left: 737px; top: 10px; display: none;">
					<button id="cancelBtn" type="button" class="btn btn-default">取消</button>
					<button type="button" class="btn btn-primary">保存</button>
				</p>
			</form>
		</div>
	</div>
	<div style="height: 200px;"></div>
</body>
</html>