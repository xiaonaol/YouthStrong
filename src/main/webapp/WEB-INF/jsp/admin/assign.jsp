<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2023/11/4
  Time: 10
  To change this template use File | Settings | File Templates.
--%>
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
        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="page-header">
                    <h1>物资审核通过，待用户捐赠：</h1>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>物资名称</th>
                                        <th>捐赠者</th>
                                        <th>捐赠者地区</th>
                                        <th>捐赠日期</th>
                                        <th>捐赠数量</th>
                                        <th>捐赠单价</th>
                                        <th>捐赠总价</th>
                                        <th>审核日期</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty bookList }">
                                            <c:forEach items="${bookList }" varStatus="index" var="book">
                                                <tr>
                                                    <td>
                                                            ${index.count }
                                                        <input type="hidden" name="b_id" value="${book.b_id }" />
                                                    </td>
                                                    <td>${book.b_name }</td>
                                                    <td>${book.b_author }</td>
                                                    <td>${book.b_publish }</td>
                                                    <td>${book.b_pdate }</td>
                                                    <td>${book.b_quantity }</td>
                                                    <td>${book.b_value }</td>
                                                    <td>${book.b_allValue }</td>
                                                    <td>${book.b_checkdate }</td>
                                                    <td>
                                                        <div class="hidden-sm hidden-xs btn-group">
                                                            <button class="btn btn-xs btn-success" title="用户已捐赠" onclick="showBooksInfo('${book.b_name}')">
                                                                <i class="ace-icon fa fa-check bigger-120"></i>分配物资
                                                            </button>
                                                            <!-- <button class="btn btn-xs btn-danger" title="取消捐赠">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button> -->
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td colspan="7"><h1>还未有审核通过的物资！</h1></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="hr hr-18 dotted hr-double"></div>
                    </div>


                    <!-- Books Info Modal -->
                    <div class="modal fade" id="booksInfoModal" tabindex="-1" role="dialog" aria-labelledby="booksModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="booksModalLabel">请选择需要分配的儿童</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>账号</th>
                                            <th>名字</th>
                                            <th>分配数量</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody id="childrenModalTableBody">
                                        <!-- Book details will be inserted here -->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>




                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    // 显示包含所有儿童信息的模态窗口
    function showBooksInfo(b_name) {
        // 从服务器端获取bookList数据，需要从服务器端模板渲染
        var children = ${childrenListJson};
        var selectedBook = b_name;
        var tableHtml = children.map(function(child,index) {
            return '<tr>' +
                '<td>' + child.children_account + '</td>' +
                '<td>' + child.children_name + '</td>' +
                '<td>' +
                '<input type="number" id="input-' + index + '" class="form-control" />' + // 添加一个输入框
                '</td>' +
                '<td>' +
                '<div class="hidden-sm hidden-xs btn-group">' +
                '<button class="btn btn-xs btn-success" title="分配物资"  '+
                'onclick="assignBooksToChildren(\'' + selectedBook + '\', \'' + child.children_account + '\', ' + index + ')">'
                +
                '<i class="ace-icon fa fa-check bigger-120"></i>' +
                '</button>' +
                // 如果需要其他按钮，可以在这里添加
                '</div>' +
                '</td>' +
                '</tr>';
        }).join('');
        document.getElementById('childrenModalTableBody').innerHTML = tableHtml;
        $('#booksInfoModal').modal('show');
    }

    function assignBooksToChildren(b_name, childrenAccount, index) {
        // 获取输入框中的分配数量
        var quantity = document.getElementById('input-' + index).value;
        // 构建要发送的数据对象
        var data = {
            b_name: b_name,
            childrenAccount: childrenAccount,
            quantity: quantity
        };
        // 发送数据到服务器，您需要根据实际情况修改URL和数据处理方式
        $.ajax({
            type: 'post',
            url: 'assign_materials', // 这里填写您的服务器端接收数据的URL
            data: JSON.stringify(data), // 将对象转换为JSON字符串
            contentType: 'application/json', // 设置发送数据的格式为 JSON
            dataType: 'json', // 期望从服务器接收的数据类型为JSON
            success: function(response) {
                // 这里处理成功后的回调
                console.log('Assignment successful', response);
                // 关闭模态窗口或进行其他操作
                $('#booksInfoModal').modal('hide');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                // 这里处理错误的回调
                console.error('Assignment failed', textStatus, errorThrown);
                // 你可能还想检查 jqXHR.responseText
            }
        });
    }

</script>


</body>
</html>