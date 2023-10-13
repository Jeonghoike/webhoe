<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="">
		<p class="paging">
			이름 <input type="text" name="schName" value="${param.schName.toUpperCase().trim() }">
			직책 <input type="text" name="schJob" value="${param.schJob.toUpperCase().trim()}">
			<input type="submit" value="검색">
		</p>
	</form>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>
			<th>입사일</th><th>급여</th><th>상여</th><th>부서</th>
		</tr>
		<c:if test="${emps.isEmpty() }">
			<tr><td colspan="8">사원이 없습니다</td></tr>
		</c:if>
		<c:if test="${!emps.isEmpty() }">
			<c:forEach var="emp" items="${emps }">
				<tr>
					<td>${emp.empno }</td>
					<td>
						<c:if test="${emp.sal >= 2500 }">
							<img src="${conPath }/img/hot.gif">
						</c:if>
						<c:if test="${emp.mgr eq 0 }">
							<b style="color:green;">${emp.ename }</b>
						</c:if>
						<c:if test="${emp.mgr != 0 }">
							${emp.ename }
						</c:if>
					</td>
					<td>${emp.job }</td>
					<td>${emp.mgr eq 0 ? "-" : emp.mgr }</td>
					<td>
						<fmt:formatDate value="${emp.hiredate }" pattern="yy년MM월dd일(E)"/>
					</td>
					<td>
						<fmt:formatNumber value="${emp.sal }" groupingUsed="true"/>
					</td>
					<td>
						<c:if test="${emp.comm eq 0 }"> - </c:if>
						<c:if test="${emp.comm != 0 }">
							<fmt:formatNumber value="${emp.comm }" pattern="#,###"/>
						</c:if>
					</td>
					<td>${emp.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>