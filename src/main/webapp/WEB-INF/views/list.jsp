<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./resources/compnent/jquery-3.3.1.min.js"></script>
<script src="./resources/compnent/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="./resources/js/personalHistory/personalHistory.js?ver=3" charset="UTF-8"></script>
<script src="./resources/js/personalHistory/personalHistoryFunc.js?ver=3" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/personalHistory/personalHistory.css?ver=1">
<title>List</title>
</head>
<body>


	<div class="user-info-list-pannel">
		<div class="personal-history-title-pannel">
			<h3>개인 이력 목록</h3>
		</div>
		<table class="pop-register-list">
			<thead>
				<tr>
					<td rowspan="2">등록번호</td>
					<td rowspan="2">성명</td>
					<td rowspan="2">소속회사</td>
					<td rowspan="2">부서</td>
					<td rowspan="2">성별</td>
					<td rowspan="2">경력</td>
					<td rowspan="2">등록날짜</td>
					<td rowspan="2">결혼유무</td>
				</tr>
			</thead>
			<tbody>
				
				
				
				
			</tbody>
		</table>
		<div class="pop-paging-pannel">
			</div>


	</div>
	<script type="text/javascript">
	
	userListPagingView(1);
		 
	 
</script>
</body>
</html>