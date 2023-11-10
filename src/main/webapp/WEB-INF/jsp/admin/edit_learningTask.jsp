<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>物资捐赠管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		<script src="${pageContext.request.contextPath}/assets/js/ace-extra.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	</head>
	<body class="no-skin">
		<div class="main-container ace-save-state" id="main-container">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<div class="page-header"><h1>管理员-修改学习任务信息</h1></div>
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 儿童姓名 </label>
										<div class="col-sm-9">
											<input type="hidden" id="id" value="${learningTask.id }" />
											<input type="text" id="child_name" name="child_name" value="${learningTask.child_name }" readonly="readonly" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 任务内容 </label>
										<div class="col-sm-9">
											<input type="text" id="context" name="context" value="${learningTask.context }" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 开始时间 </label>
										<div class="col-sm-9">
											<input type="date" id="start_date" name="start_date" readonly="readonly" value="${learningTask.start_date}"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 结束时间 </label>
										<div class="col-sm-9">
											<input type="date" id="end_date" name="end_date" value="${learningTask.end_date}"/>
										</div>
									</div>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="btn_submit" onclick="editLearningTaskInfo()">
												<i class="ace-icon fa fa-check bigger-110"></i>
												保存修改
											</button> &nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset" onclick="returnSelect()">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												取消
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function returnSelect() {
				window.location.href='learningTaskList';
			}
			function editLearningTaskInfo() {
				var id = $('#id').val();
				var	context = $('#context').val();
				var	child_name = $('#child_name').val();
				var	start_date = $('#start_date').val();
				var	end_date = $('#end_date').val();

				$.ajax({
					type : "post",
					url : "adminEditLearningTaskInfo",
					data : {"id":id,"context":context,"child_name":child_name,"start_date":start_date,"end_date":end_date},
					dataType : 'json',
					success(data){
						if (data.msg === "success") {
							alert("学习任务修改成功！");
							window.location.href="learningTaskList";
						} else {
							alert("学习任务修改失败");
						}
					},
					error : function() {
						alert('学习任务修改失败');
					}
				});
			}
		</script>
	</body>
</html>