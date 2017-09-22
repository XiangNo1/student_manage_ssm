<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
		<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/jquery-1.11.1.js"></script>
				<script type="text/javascript" src="${pageContext.request.contextPath }/lib/bootstrap/js/bootstrap.js"></script>
	</head>
	<body>
		<div class="container-fluid">
		
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">教务管理系统</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/student/searchByCondition.action"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 学生管理 <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/banji/findBanji.action"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 班级管理 </a></li>
        <li><a href="${pageContext.request.contextPath}/banji/findKecheng.action"> <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> 课程管理 </a></li>
        <li><a href="${pageContext.request.contextPath}/banji/findJiaowu.action"> <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 教务管理 </a></li>
        <li><a href="#"> 欢迎回来:${accounts.name }</a> </li>
        
        
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath }/student/loginout.action"> 退出登陆</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
          <ul class="dropdown-menu">
          			<li><a href="#">帐号： ${accounts.name }   密码:  ${accounts.password }</a></li>
          
          <%-- <c:forEach items="${onlineStudentList }" var="accounts">
			<li><a href="#">帐号： ${accounts.name }   密码:  ${accounts.password }</a></li>
		  </c:forEach> --%>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		
		
		
		
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/student/searchByCondition.action" class="list-group-item active">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student/addStudent.action" class="list-group-item">添加学生</a>
		                
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student/searchByCondition.action">学生管理</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/student/addStudent.action">添加学生</a>
		                </li>
		                <li><input  class="btn btn-primary" type="button" onclick="deleteAll()" value="批量删除"/></li>
		            </ul>
		            <div class="alert alert-info" role="alert">删除前请认真核对学生的姓名等<strong>确保无误</strong></div>
				      <form id="searchForm" class="container" action="${pageContext.request.contextPath}/student/searchByCondition.action" method="post">
					    	<input type="hidden" name="pageIndex" id="pageIndex" />
					  	 	    姓名:<input type="text" name="name" value="${searchCondition.name}"/>
					    	   年龄:<input type="text" name="age" value="${searchCondition.age}"/>
					   		    性别:<select id="gender" name="gender">
					               <option value="">不限</option>
					               <option value="男">男</option>
					               <option value="女">女</option>
					           	</select>
					                               地址：<input type="text" name="address" value="${searchCondition.address}"/>
					           	 班级:<select id="banji" name="banji" id="banji">
					           	 <option value="">不限</option>
	         <c:forEach items="${banjiList }" var="banji">
					               <option value="${banji.name }">${banji.name }</option>
					               
					       </c:forEach>        
					           	</select>
					           	&nbsp;&nbsp;&nbsp;
					      	 <button class="btn btn-primary">搜索</button>
					    </form>
					    
					    
					    <form id="mainForm" action="" method="post">
						            <table class="table">
						                <thead>
						                    <tr>
						                    <th><input type="checkbox" onclick="selectAll()" id="selectAlls"/></th>
						                        <th>id</th>
												<th>姓名</th>
												<th>年龄</th>
												<th>性别</th>
												<th>地址</th>
												<th>出生日期</th>
												<th>班级</th>
												<th>删除</th>
												<th>修改</th>
						                    </tr>
						                </thead>
						                <tbody>
						                    
								<c:forEach items="${requestScope.pageBean.list}" var="student">
									<tr>
									<td><input type="checkbox" name="selectIds" value="${student.id }"/></td>
										<td>${student.id}</td>
										<td>${student.name }</td>
										<td>${student.age }</td>
										<td>${student.gender}</td>
										<td>${student.address}</td>
										<td>
										<fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/>
										</td>
										<td>${student.banji.name }</td>
										<td><a href="javascript:delStudent(${student.id });">删除</a></td>
										<td><a href="${pageContext.request.contextPath }/student/updateStudent.action?id=${student.id}">修改</a></td>
									</tr>
								</c:forEach>
						                </tbody>
						            </table>
		            
		            </form>
		            
		            <!-- 分页开始 -->
				<nav aria-label="Page navigation" class="pull-right">
				 <ul class="pagination">
			    <c:if test="${pageBean.pageIndex==1}">
		              <li class="disabled">
		                 <a href="javascript:void(0);" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
          		 </c:if>
		           <c:if test="${pageBean.pageIndex!=1}">
		              <li>
		                 <a href="javascript:goPage('${pageBean.pageIndex-1}');" aria-label="Previous">
		                   <span aria-hidden="true">&laquo;</span>
		                 </a>
		              </li>
		           </c:if>

			   <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
              <c:if test="${pageBean.pageIndex!=page}">
                   <li><a href="javascript:goPage('${page }');">${page}</a></li>
              </c:if>
              <!-- 遍历的时候page和pageIndex相等，高亮显示 -->
              <c:if test="${pageBean.pageIndex==page}">
                   <li class="active"><a href="javascript:void(0);">${page}</a></li>
              </c:if>
           </c:forEach>

			  
			   
			 <c:if test="${pageBean.pageIndex == pageBean.totalPage}">
		              <li class="disabled">
		                 <a href="javascript:void(0);" aria-label="Previous">
		                   <span aria-hidden="true">&raquo;</span>
		                 </a>
		              </li>
          		 </c:if>
		           <c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
		              <li>
		                 <a href="javascript:goPage('${pageBean.pageIndex+1}');" aria-label="Previous">
		                   <span aria-hidden="true">&raquo;</span>
		                 </a>
		              </li>
		           </c:if>
			 
			 
			 
			  </ul>
				</nav>
				<!-- 分页结束 -->
		        </div>
		    </div>
		</div>
		
	<script>
	function goPage(pageIndex){
		$("#pageIndex").val(pageIndex);
		$("#searchForm").submit();
	}
	
	$(function(){
	       $("#banji option[value='${searchCondition.banji}']").prop("selected", true);
	    });
	$(function(){
	       $("#gender option[value='${searchCondition.gender}']").prop("selected", true);
	    });
	function delStudent(id) {
	       var isDel = confirm("您确认要删除吗？");
	       if (isDel) {
	           //要删除
	           location.href = "${pageContext.request.contextPath}/student/deleteStudent.action?id="
	                  + id;
	       }
	    };
	function selectAll() {
		
		$("input[name=selectIds]").prop('checked',$("#selectAlls").is(":checked"))
	};
	
	function deleteAll() {
		 var isDel = confirm("您确认要删除吗？");
		    if (isDel) {
		       //要删除
		       $("#mainForm").attr("action", "${pageContext.request.contextPath}/student/deleteAllStudent.action");
		       $("#mainForm").submit();
		    }

	};

</script>	
	</body>
</html>