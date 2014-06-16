


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert a Property as text</h1>
<form name="form1" action="rest/simple" method="POST">
Key &nbsp;<input type="text" name="key" >
Value &nbsp;<input type="text" name="value" >
<input type="submit" value="Invoke REST">
</form>

<br />
<h1>Insert a Property as XML</h1>
<form name="form2" action="rest/simple" method="POST">
<textarea name="xml" rows="10" cols="30" ></textarea>
 

<input type="submit" value="Invoke REST">
</form>

<br/>

<a href="rest/simple/json">Get List as Json</a> 
<a href="rest/simple/xml">Get List as XML</a> 

<a href="TestRS">REST client</a> 
</body>
</html>