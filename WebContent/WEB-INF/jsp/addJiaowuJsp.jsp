<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <li><a href="${pageContext.request.contextPath}/student/searchByCondition.action"> <span class="glyphicon glyphicon-user" aria-hidden="true"></span> 学生管理 <span class="sr-only">(current)</span></a></li>
        <li><a href="${pageContext.request.contextPath}/banji/findBanji.action"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 班级管理 </a></li>
        <li><a href="${pageContext.request.contextPath}/banji/findKecheng.action"> <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> 课程管理 </a></li>
        <li class="active"><a href="${pageContext.request.contextPath}/banji/findJiaowu.action"> <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 教务管理 </a></li>
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
		                <a href="${pageContext.request.contextPath}/banji/findJiaowu.action" class="list-group-item">学生教务管理</a>
		               		                <a href="${pageContext.request.contextPath}/banji/findBanjiKecheng.action" class="list-group-item">班级课程管理</a>
		               		                <a href="${pageContext.request.contextPath}/banji/findBanjiStudent.action" class="list-group-item">班级学生查询</a>
		                <a href="${pageContext.request.contextPath}/banji/addJiaowu.action" class="list-group-item active">为班级添加课程</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li>
		                    <a href="${pageContext.request.contextPath}/banji/findJiaowu.action">学生教务管理</a>
		                </li>
		                 <li>
		                     <a href="${pageContext.request.contextPath}/banji/findBanjiKecheng.action">班级课程管理</a>
		                </li>
		                 <li>
		                     <a href="${pageContext.request.contextPath}/banji/findBanjiStudent.action">班级学生查询</a>
		                </li>
		                <li class="active">
		                     <a href="${pageContext.request.contextPath}/banji/addJiaowu.action">为班级添加课程</a>
		                </li>
		            </ul>
				      
		           <form action="${pageContext.request.contextPath}/banji/addJiaowu2.action" method="post">
					            <span style="line-height:30px;" class="text-info">为班级添加课程：</span><br/>
					            <div class="alert alert-danger" role="alert">请不要为班级添加重复的课程！！！</div>
					        <span style="line-height:30px;" class="text-info">    班级：</span><select id="banji" name="banji"  class="form-control">
	        				 	<c:forEach items="${banjiList }" var="banjis">
					               <option value="${banjis.id }">${banjis.name }</option>
					               
					    	   </c:forEach>        
					           	</select>
					     	<span style="line-height:30px;" class="text-info">课程：</span><select id="kecheng" name="kecheng"  class="form-control">
	        				 	<c:forEach items="${kechengList }" var="kecheng">
					               <option value="${kecheng.id }">${kecheng.name }</option>
					               
					    	   </c:forEach>        
					           	</select>
					           	<input class="btn btn-primary" type="submit" value="添加"/>
		            </form>
		            </div> 
				      
		           
		      </div>
		      </div>
		     
		
	<script>
	
	
	


</script>	
	</body>
</html>
