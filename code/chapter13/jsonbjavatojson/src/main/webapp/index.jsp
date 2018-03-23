<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Properties for Person</h2>
    <form method="post" action="rest/jsonb/tojson">
      <label>Name</label><br/>
      <input type="text" name="name"><br />
      <label>Surname</label><br/>
      <input type="text" name="surname"><br />
      <label>Address</label><br/>
      <input type="text" name="address"><br />
      <label>City</label><br/>
      <input type="text" name="city"><br />    
      <label>&nbsp;</label>  <br/>
       <input type="submit" value="Create Json">
    </form>
    
 
<br />
<h2>Enter Json for Object "Person" here:</h2>
<h3>Example: {

    "name": "John",
    "surname": "Doe",
    "address": "77 E 4th St",
    "city": "New York"

}</h3>
<form method="post" action="rest/jsonb/tojava">
Json<br/>
<input type="text" name="json" width="400"/>  <br>
 
 <br/>
  <input type="submit" value="Create Java">
</form>
</body>
</html>