<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TEST</title>
</head>
<body>
	<hr>【保存 枚举类型】 
	<form action="/api/test?service=saveEnumItem" method="post"  >
		内容<input name="prop.content" /><br/>
		<input type="radio" name="prop.type" value="SCHOOL_TYPE" />学校|
		<input type="radio" name="prop.type" value="SCHOOL_GRADE" />年级|
		<input type="radio" name="prop.type" value="LAB_CATEGORY" />实验室类型|
		<input type="radio" name="prop.type" value="LAB_ATTRIBUTE" />实验室特性|
		<br>
		<input type="submit" value="submit" /> 
	</form>
	<hr>【根据类型查询】
	<form action="/api/test?service=getEnumByType" method="post"  >
		<input type="radio" name="type" value="SCHOOL_TYPE" />学校|
		<input type="radio" name="type" value="SCHOOL_GRADE" />年级|
		<input type="radio" name="type" value="LAB_CATEGORY" />实验室类型|
		<input type="radio" name="type" value="LAB_ATTRIBUTE" />实验室特性|
		<br>
		<input type="submit" value="submit" /> 
	</form>
	<hr>【保存 学校信息】
	<form action="/api/test?service=saveSchool" method="post"  >
		名称<input name="prop.name" /> | 代码<input name="prop.code" />
		| 类型编号 <input name="prop.typeNO" />
		<br>
		<input type="submit" value="submit" /> 
	</form>
</body>
</html>