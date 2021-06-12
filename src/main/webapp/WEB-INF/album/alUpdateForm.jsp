<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>update.jsp</title>
	<style type="text/css">
		.err{
			font-weight: bolder;
			font-size: 9pt;
			color: red;
		}
	</style>
</head>
<body>
	<!-- 교안 387쪽 -->
	<h1><spring:message code="album.register"/></h1>
	<c:set var="xx" value="<%=myContext %>"/>
	
	<!-- pom.xml 파일에 버전 5.x으로 설정이 되어서 comandName이 아닌 modelAttribute를 사용해야한다. -->
	<form:form modelAttribute="album" method="post" action="${xx}/update.al" enctype="multipart/form-data" >
	<table>
		<tr>
			<td align="center">
				<spring:message code="album.id"/> 
			</td>
			<td align="left">
				<form:input path="id" disabled="true"/>
				<input type="hidden" name="id" value="${album.id}">
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.albumname"/> 
			</td>
			<td align="left">
				<form:input path="albumname" />
				<form:errors path="albumname" cssClass="err" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.image"/>
			</td>
			<td align="left">
				<input type="file" name="abcd">
				<form:errors path="abcd" cssClass="err" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.song"/>
			</td>
			<td align="left">
				<form:input path="song" />
				<form:errors cssClass="err" path="song" />				
			</td>
		</tr>		
		<tr>
			<td align="center">
				<spring:message code="album.lyricist"/>
			</td>
			<td align="left">
				<form:input path="lyricist" />
				<form:errors cssClass="err" path="lyricist" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.songwriter"/>
			</td>
			<td align="left">
				<form:input path="songwriter" />
				<form:errors cssClass="err" path="songwriter" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.transcription"/>
			</td>
			<td align="left">
				<form:input path="transcription" />
				<form:errors cssClass="err" path="transcription" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.writerdate"/>
			</td>
			<td align="left">
				<form:input path="writerdate" />
				<form:errors cssClass="err" path="writerdate" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.genre"/>
			</td>
			<td align="left">
				<form:select path="genre">
					<form:options items="${genrelist}" itemLabel="mykey" itemValue="mykey"/>
				</form:select>				
				<form:errors cssClass="err" path="genre" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.mediatype"/>
			</td>
			<td align="left">
				<form:checkboxes items="${mediatypelist}" path="mediatype"
					itemLabel="mykey" itemValue="mykey" />
				<form:errors cssClass="err" path="mediatype" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.emailagree"/>
			</td>
			<td align="left">
				<form:radiobuttons items="${emailagreelist}" path="emailagree" 
						itemLabel="mykey" itemValue="mykey" />
				<form:errors cssClass="err" path="emailagree" />				
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" 
					value="<spring:message code="album.update"/>"/>	
			</td>
		</tr>		
	</table>
	</form:form>
	
	<!-- 앨범 추가시 선택한 체크 박스는 on 상태로 보여 주기 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			// 체크 박스가 mediatype인 항목들
			var checkboxes = $("input[name='mediatype']")
			
			checkboxes.each(function(){ // 반복문을 사용하여
				var typename = $(this).val(); // 각 항목의 체크 박스의 값
				if("${album.mediatype}".indexOf(typename) >= 0){ // 이름이 포함되어 있스면
					$(this).attr("checked", true); // 체크 상태로 표시
				}
			});
		});
	</script>
</body>
</html>