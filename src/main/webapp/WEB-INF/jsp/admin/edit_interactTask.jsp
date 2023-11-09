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
						<div class="page-header"><h1>管理员-修改交互任务信息</h1></div>
						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 儿童姓名 </label>
										<div class="col-sm-9">
											<input type="hidden" id="id" value="${interactTask.id }" />
											<input type="text" id="child_name" name="child_name" value="${interactTask.child_name }" readonly="readonly" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 志愿者姓名 </label>
										<div class="col-sm-9">
											<input type="text" id="volunteer_name" name="volunteer_name" value="${interactTask.volunteer_name }" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 任务内容 </label>
										<div class="col-sm-9">
											<input type="text" id="context" name="context" value="${interactTask.context }" class="col-xs-10 col-sm-5" />
										</div>
									</div>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="btn_submit" onclick="editInteractTaskInfo()">
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
				window.location.href='interactTaskList';
			}
			function editInteractTaskInfo() {
				var id = $('#id').val();
				var volunteer_name = $('#volunteer_name').val();
				var context = $('#context').val();

				$.ajax({
					type : "post",
					url : "adminEditInteractTaskInfo",
					data : {"id":id,"volunteer_name":volunteer_name,"context":context},
					dataType : 'json',
					success : function(data){
						if (data.msg == 'success') {
							alert("交互任务修改成功！");
							window.location.href="interactTaskList";
						} else {
							alert("交互任务修改失败");
						}
					},
					error : function() {
						alert('交互任务修改失败');
					}
				});
			}
		</script>
	</body>
</html>