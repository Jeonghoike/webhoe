<%@page import="com.lec.emp.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.emp.EmpDao"%>
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
	<%--requestScope.emps출력 --%>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일(T)</th>
			<th>입사일(D)</th><th>급여</th><th>상여</th><th>부서</th>
		</tr>
		<c:if test="${emps.size() eq 0 }">
			<tr><td colspan="9">사원이 없습니다</td></tr>
		</c:if>
		<c:if test="${emps.size() != 0 }">
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
						<fmt:formatDate value="${emp.hiredate }" pattern="yy년MM월dd일(E) hh:mm:ss(a)"/>
					</td>
					<td>
						<fmt:formatDate value="${emp.hireDate }" pattern="yy년MM월dd일(E) hh:mm:ss(a)"/>
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