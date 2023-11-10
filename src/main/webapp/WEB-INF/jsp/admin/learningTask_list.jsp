<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>物资捐赠管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/components/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	</head>
	<body class="no-skin">
		<div class="main-container ace-save-state" id="main-container">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<div class="page-header">
							<h1>学习任务信息：</h1>
						</div>

						<form action="findLearningTask">
							<input type="text" id="key" name="key" placeholder="儿童姓名">
							<button type="submit" >查询</button>
						</form>

						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<table id="simple-table" class="table  table-bordered table-hover">
											<thead>
												<tr>
													<th>序号</th>
													<th>儿童姓名</th>
													<th>任务内容</th>
													<th>开始时间</th>
													<th>结束时间</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${not empty learningTaskList }">
														<c:forEach items="${learningTaskList }" varStatus="index" var="learningTask">
															<tr>
																<td>
																	${index.count }
																	<input type="hidden" name="id" value="${learningTask.id }" />
																</td>
																<td>${learningTask.child_name }</td>
																<td>${learningTask.context }</td>
																<th>${learningTask.start_date}</th>
																<th>${learningTask.end_date}</th>
																<td>
																	<div class="hidden-sm hidden-xs btn-group">
																		<!-- <button class="btn btn-xs btn-success">
																			<i class="ace-icon fa fa-check bigger-120"></i>
																		</button> -->
																		<button class="btn btn-xs btn-info" title="编辑" onclick="toAdminEditLearningTask('${learningTask.id}')">
																			<i class="ace-icon fa fa-pencil bigger-120"></i>
																		</button>
																		<button class="btn btn-xs btn-danger" title="删除" onclick="adminDelLearningTaskById('${learningTask.id}')" >
																			<i class="ace-icon fa fa-trash-o bigger-120"></i>
																		</button>
																	</div>
																</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="6"><h1>无学习任务信息！</h1></td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
								<button onclick="toCreateLearningTask()">新建任务</button>
								<div class="hr hr-18 dotted hr-double"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			
			// 编辑用户信息
			function toAdminEditLearningTask(id) {
				window.location.href="toAdminEditLearningTask?id=" + id;
			}
			
			// 删除用户.
			function adminDelLearningTaskById(id) {
				if (confirm('确定要删除该任务吗？')) {
					$.ajax({
						type : "post",
						url : "adminDelLearningTaskById",
						data : {"id":id},
						dataType : 'json',
						success : function(data){ 
							if (data.msg == 'success') {
								alert("删除成功！");
								window.location.href="learningTaskList";
							} else {
								alert("删除失败!");
							}
						},
						error : function() {
							alert('操作错误！');
						}
					});
				}
			}

			function toCreateLearningTask() {
				window.location.href="toAdminCreateLearningTask";
			}

			function find() {
				// 构建要发送的数据对象
				var key = $('#key').val();
				// 发送数据到服务器，您需要根据实际情况修改URL和数据处理方式
				$.ajax({
					type: 'post',
					url: 'findLearningTask', // 这里填写您的服务器端接收数据的URL
					data: {"key":key}, // 将对象转换为JSON字符串
					dataType : 'json' // 设置发送数据的格式为 JSON
				});
			}
		</script>
	</body>
</html>