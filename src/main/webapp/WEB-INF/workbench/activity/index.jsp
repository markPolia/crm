<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%pageContext.setAttribute("base", request.getScheme() + "://" + request.getServerName()
		+ ":" + request.getServerPort() + request.getContextPath() + "/");
		pageContext.setAttribute("contextPath", request.getContextPath());%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>市场活动</title>
	<link href="${contextPath}/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="${contextPath}/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />
	<link href="${contextPath}/jquery/bs_pagination/jquery.bs_pagination.min.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" charset="UTF-8" src="${contextPath}/jquery/jquery-1.11.1-min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${contextPath}/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${contextPath}/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${contextPath}/jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${contextPath}/jquery/bs_pagination/en.js"></script>
	<script type="text/javascript">
		;(function($){
			$.fn.datetimepicker.dates['zh-CN'] = {
				days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
				daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
				daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
				months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
				monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
				today: "今天",
				suffix: [],
				meridiem: ["上午", "下午"]
			};
		}(jQuery));

		function pageList(pageNo, pageSize) {
			$('input[name=check-one]:checked').prop('checked', false);

			let $search_name = $('#search-name');
			let $search_owner = $('#search-owner');
			let $search_start_date = $('#search-start-date');
			let $search_end_date = $('#search-end-date');
			$.ajax({
				url : '${contextPath}/workbench/activity/activitiesList',
				type : 'GET',
				data : {
					pageNo : pageNo,
					pageSize : pageSize,
					name : $search_name.val(),
					owner : $search_owner.val(),
					startDate : $search_start_date.val(),
					endDate : $search_end_date.val()
				},
				async : true,
				dataType : 'JSON',
				success : function (activitiesListJsonStr) {
					let html = '';
					let data = eval(activitiesListJsonStr);
					$.each(data.dataList, function (index, activity) {
						html +=
						'<tr class="active">' +
							'<td><input type="checkbox" name="check-one" value="' + activity.id + '"/></td>' +
							'<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href=\'detail\';">' + activity.name + '</a></td>' +
							'<td>' + activity.owner + '</td>' +
							'<td>' + activity.startDate + '</td>' +
							'<td>' + activity.endDate + '</td>' +
						'</tr>';
					});
					// 展示数据
					$('#activitiesListTableBody').html(html);

					$('#hidden-name').val($.trim($search_name.val()));
					$('#hidden-owner').val($.trim($search_owner.val()));
					$('#hidden-start-date').val($.trim($search_start_date.val()));
					$('#hidden-end-date').val($.trim($search_end_date.val()));
					/////////////////////////// 分页插件 //////////////////////////////
					$("#activityPage").bs_pagination({
						currentPage: pageNo, // 页码
						rowsPerPage: pageSize, // 每页显示的记录条数
						maxRowsPerPage: 20, // 每页最多显示的记录条数
						totalPages: data.pageSize, // 总页数
						totalRows: data.total, // 总记录条数

						visiblePageLinks: 3, // 显示几个卡片

						showGoToPage: true,
						showRowsPerPage: true,
						showRowsInfo: true,
						showRowsDefaultInfo: true,

						onChangePage : function(event, data){
							$('#check-all-box').prop('checked', false);
							$search_name.val($.trim($('#hidden-name').val()));
							$search_owner.val($.trim($('#hidden-owner').val()));
							$search_start_date.val($.trim($('#hidden-start-date').val()));
							$search_end_date.val($.trim($('#hidden-end-date').val()));
							pageList(data.currentPage , data.rowsPerPage);
						}
					});
					//////////////////////////////////////////////////////////////////////
				}
			});
		}

		$(function() {
			// 展示市场活动列表
			pageList(1, 2);
			// 查询
			$('#search-bth').click(function () {
				pageList(1 ,$("#activityPage").bs_pagination('getOption', 'rowsPerPage'));
			});
			// 创建打开添加模态按钮
			$('#createModalBtn').click(function () {
				$(".time").datetimepicker({
					minView: "month",
					language:  'zh-CN',
					format: 'yyyy-mm-dd',
					autoclose: true,
					todayBtn: true,
					pickerPosition: "bottom-left"
				});

				$.ajax({
					type : 'GET',
					url : '${contextPath}/workbench/activity/getUserList',
					async : true,
					dataType : 'JSON',
					success : function (jsonStr) {
						let html = '';
						$.each(eval(jsonStr), function (index, user){
							html += '<option value=\'' + user.id + '\'>' + user.name + '</option>';
						});
						let $create = $('#create-marketActivityOwner');
						$create.html(html);
						$create.val('${sessionScope.user.id}');
					}
				});
				$('#createActivityModal').modal('show');
			});

			// 更新市场活动操作
			$('#update-btn').click(function () {
				$('#editActivityModal').modal('hide');
				$.ajax({
					url : '${contextPath}/workbench/activity/updateMarkActivity',
					data : {
						'id' : $.trim($('#edit-aid').val()),					/* aid      */
						'owner' : $.trim($('#edit-marketActivityOwner').val()), /* 所有者   */
						'name' : $.trim($('#edit-marketActivityName').val()),   /* 名称     */
						'startDate' : $.trim($('#edit-startTime').val()), 	    /* 开始日期 */
						'endDate' : $.trim($('#edit-endTime').val()),           /* 结束日期 */
						'cost' : $.trim($('#edit-cost').val()),                 /* 成本     */
						'description' : $.trim($('#edit-description').val())    /* 描述     */
					},
					dataType : 'JSON',
					type : 'POST',
					async : true,
					success : function (jsonStr) {
						if (eval(jsonStr).success) {
							// 更新成功
							// 关闭
							$('#createActivityModal').modal('hide');
							// 局部刷新市场活动列表
							let $activityPage = $("#activityPage");
							pageList($activityPage.bs_pagination('getOption', 'currentPage'),
									$activityPage.bs_pagination('getOption', 'rowsPerPage'));
						} else {
							// 更新失败
							alert('更新失败');
						}
					}
				});
			});

			// 创建打开修改模态按钮时的事件
			$('#editModalBtn').click(function () {
				let $check_one = $('input[name=check-one]:checked');
				if ($check_one.length === 1) {
					$('#editActivityModal').modal('show');
					$.ajax({
						url : '${contextPath}/workbench/activity/before/update_list_activity',
						data : {
							id : $check_one.val()
						},
						type : 'GET',
						dataType : 'JSON',
						async : true,
						success : function (data) {
							// userList[] : name , activity : value
							// 处理用户列表
							let option_html = '';
							let json_data = eval(data);
							$.each(json_data.userList, function (index, user) {
								if (data.activity.owner === user.name) {
									option_html += '<option value=\'' + user.id + '\' selected>' + user.name + '</option>';
								} else {
									option_html += '<option value=\'' + user.id + '\'>' + user.name + '</option>';
								}
							});
							$('#edit-marketActivityOwner').html(option_html);
							// 处理activity数据
							$('#edit-marketActivityName').val(data.activity.name);
							$('#edit-startTime').val(data.activity.startDate);
							$('#edit-endTime').val(data.activity.endDate);
							$('#edit-cost').val(data.activity.cost);
							$('#edit-description').val(data.activity.description);
							$('#edit-aid').val(data.activity.id);
							// 刷新
							pageList(1 ,$("#activityPage").bs_pagination('getOption', 'rowsPerPage'));
						}
					});
				} else if($check_one.length === 0) {
					alert('请选择要修改的对象');
				} else if ($check_one.length >= 2) {
					alert('一次只能更改一个对象');
				} else {
					alert('wrong');
				}
			});

			// 添加市场活动操作
			$('#createMarkActivityBtn').click(function () {
				$.ajax({
					url : '${contextPath}/workbench/activity/createMarkActivity',
					data : {
						'owner' : $.trim($('#create-marketActivityOwner').val()), /* 所有者   */
						'name' : $.trim($('#create-marketActivityName').val()),   /* 名称     */
						'startDate' : $.trim($('#create-startTime').val()), 	  /* 开始日期 */
						'endDate' : $.trim($('#create-endTime').val()),           /* 结束日期 */
						'cost' : $.trim($('#create-cost').val()),                 /* 成本     */
						'description' : $.trim($('#create-describe').val())       /* 描述     */
					},
					dataType : 'JSON',
					type : 'POST',
					async : true,
					success : function (jsonStr) {
						if (eval(jsonStr).success) {
							/*
								currentPage 操作后停留在当前页
								rowsPerPage 操作后维持已经设置好的每页展示的记录数
							*/
							// 添加成功
							// 关闭
							$('#createActivityModal').modal('hide');
							// 清空表单
							$('#saveActivityForm')[0].reset();
							// 局部刷新市场活动列表
							let $activityPage = $("#activityPage");
							pageList(1 ,$activityPage.bs_pagination('getOption', 'rowsPerPage'));
						} else {
							// 添加失败
							alert('添加失败');
						}
					}
				});
			});

			// 选择全部
			$('#check-all-box').click(function () {
				$('input[name=check-one]').prop("checked", this.checked);
			});

			/*
			* 	绑定需要元素的外层元素，添加绑定事件，内部需要绑定事件的元素，和回调函数
			*/
			$('#activitiesListTableBody').on("click", $('input[name=check-one]'), function () {
				 $('#check-all-box').prop("checked", $('input[name=check-one]').length === $('input[name=check-one]:checked').length);
			});

			// 删除市场活动操作
			$('#deleteActivityBtn').click(function () {
				let $select = $('input[name=check-one]:checked');
				if ($select.length === 0) {
					alert('未选中要删除的元素');
				} else {
					if (confirm('确定删除所选记录？')) {
						let params = '';
						for (let i = 0; i < $select.length; i++) {
							params += 'id=' + $select[i].value;
							if (i !== $select.length - 1) params += '&';
						}
						$.ajax({
							type : 'POST',
							url : '${contextPath}/workbench/activity/deleteMarkActivity',
							dataType : 'JSON',
							async : true,
							data : params,
							success : function (jsonStr) {
								if (eval(jsonStr).success) {
									pageList(1 ,$("#activityPage").bs_pagination('getOption', 'rowsPerPage'));
									alert('删除成功');
								} else {
									alert('未知错误，删除失败！');
								}
							}
						});
					}
				}
			});
		});
	</script>
</head>
<body>
	<input type="hidden" id="hidden-name" value=" "/>
	<input type="hidden" id="hidden-owner" value=" "/>
	<input type="hidden" id="hidden-start-date" value=" "/>
	<input type="hidden" id="hidden-end-date" value=" "/>
	
	<!-- 创建市场活动的模态窗口 -->
	<div class="modal fade" id="createActivityModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel1">创建市场活动</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="saveActivityForm">
						<div class="form-group">
							<label for="create-marketActivityOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-marketActivityOwner">
									<option>请选择用户</option>
								</select>
							</div>
                            <label for="create-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-marketActivityName">
                            </div>
						</div>
						<div class="form-group">
							<label for="create-startTime" class="col-sm-2 control-label">开始日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control time" id="create-startTime" readonly>
							</div>
							<label for="create-endTime" class="col-sm-2 control-label">结束日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control time" id="create-endTime" readonly>
							</div>
						</div>
                        <div class="form-group">
                            <label for="create-cost" class="col-sm-2 control-label">成本</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-cost">
                            </div>
                        </div>
						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
								<textarea class="form-control" rows="3" id="create-describe"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="createMarkActivityBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改市场活动的模态窗口 -->
	<div class="modal fade" id="editActivityModal" role="dialog">
		<input type="hidden" id="edit-aid">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">修改市场活动</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="edit-marketActivityOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-marketActivityOwner">
								  <option>UNKNOWN</option>
								</select>
							</div>
                            <label for="edit-marketActivityName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-marketActivityName" value="UNKNOWN">
                            </div>
						</div>
						<div class="form-group">
							<label for="edit-startTime" class="col-sm-2 control-label">开始日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control time" id="edit-startTime" readonly>
							</div>
							<label for="edit-endTime" class="col-sm-2 control-label">结束日期</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control time" id="edit-endTime" readonly>
							</div>
						</div>
						<div class="form-group">
							<label for="edit-cost" class="col-sm-2 control-label">成本</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-cost" value="UNKNOWN">
							</div>
						</div>
						<div class="form-group">
							<label for="edit-description" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
								<textarea class="form-control" rows="3" id="edit-description">UNKNOWN</textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update-btn">更新</button>
				</div>
			</div>
		</div>
	</div>

	<div>
		<div style="position: relative; left: 10px; top: -10px;">
			<div class="page-header">
				<h3>市场活动列表</h3>
			</div>
		</div>
	</div>
	<div style="position: relative; top: -20px; left: 0; width: 100%; height: 100%;">
		<div style="width: 100%; position: absolute;top: 5px; left: 10px;">
			<div class="btn-toolbar" role="toolbar" style="height: 80px;">
				<form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">名称</div>
				      <input class="form-control" type="text" id="search-name">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">所有者</div>
				      <input class="form-control" type="text" id="search-owner">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">开始日期</div>
					  <input class="form-control" type="text" id="search-start-date"/>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">结束日期</div>
					  <input class="form-control" type="text" id="search-end-date">
				    </div>
				  </div>
				  <button type="button" class="btn btn-default" id="search-bth">查询</button>
				</form>
			</div>
			<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
				<div class="btn-group" style="position: relative; top: 18%;">
				  <%--
				  		data-toggle 点击打开模态按钮
				  		data-taget  模态窗口对象

				  		无法对按钮功能进行扩充
				  --%>
				  <button type="button" class="btn btn-primary" id="createModalBtn"><span class="glyphicon glyphicon-plus"></span> 创建</button>
				  <button type="button" class="btn btn-default" id="editModalBtn"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
				  <button type="button" class="btn btn-danger" id="deleteActivityBtn"><span class="glyphicon glyphicon-minus"></span> 删除</button>
				</div>
			</div>
			<div style="position: relative;top: 10px;">
				<table class="table table-hover">
					<thead>
						<tr style="color: #B3B3B3;">
							<td><input type="checkbox" id="check-all-box"/></td>
							<td>名称</td>
                            <td>所有者</td>
							<td>开始日期</td>
							<td>结束日期</td>
						</tr>
					</thead>
					<tbody id="activitiesListTableBody">
						<tr class="active">
							<td><input type="checkbox" disabled /></td>
							<td>无数据</td>
                            <td>无数据</td>
							<td>无数据</td>
							<td>无数据</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="height: 50px; position: relative;top: 30px;">
				<div id="activityPage">
				</div>
			</div>
		</div>
	</div>
</body>
</html>