<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
<style>
td, th {
	padding: 3px;
}
</style>
</head>
<body style="margin: 40px;">
	<h1>JSTL fmt tag</h1>
	<hr>
	<table border="1">
		<tr>
			<th>ǥ�� ���</th>
			<th>���</th>
		</tr>
		<tr>
			<th>�Ϲ� ����</th>
			<th>${price}</th>
		</tr>
		<tr>
			<th>õ���� ���б�ȣ�� ���Ե� ����</th>
			<td><fmt:formatNumber type="number" value="${price}" /></td></tr>
		<tr>
			<td>��ȭ(KRW)</td>
			<td><fmt:formatNumber type="currency" currencySymbol="KRW" value="${price}" /></td>
		</tr>
		<tr>
			<td>��ȭ(USD)</td>
			<td><fmt:formatNumber type="currency" currencySymbol="$" value="${price}" /></td>
		</tr>
		<tr>
			<td>�ۼ�Ʈ</td>
			<td><fmt:formatNumber type="percent" value="${price / 100000000}" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>�Ϲ� ��¥</td>
			<td>${now}</td>
			<tr><td>full date</td>
			<td><fmt:formatDate type="date" dateStyle ="full" value="${now}" /></td></tr>
			<tr><td>short date</td>
			<td><fmt:formatDate type="date" dateStyle ="short" value="${now}" /></td></tr>
			<tr><td>time</td>
			<td><fmt:formatDate type="time" value="${now}"/></td></tr>
			<tr><td>both</td>
			<td><fmt:formatDate type="both" dateStyle ="full" timeStyle="full" value="${now}" /></td></tr>
			<tr><td>pattern("YYYY-MM-dd HH:mm:ss")</td>
			<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss"  value="${now}" /></td></tr>
			<tr><td>LocalDate now</td><td>${ldNow}</td></tr>
			<tr><td>LocalTime now ����</td><td>${ltNow2}</td></tr>
			<tr><td>LocalTime now</td><td>${ltNow}</td></tr>
			<tr><td>LocalDateTime now</td><td>${ldtNow}</td></tr>
			<tr><td>LocalDateTime now ����</td><td>${ldtNow2}</td></tr>
	
	</table>

</body>
</html>