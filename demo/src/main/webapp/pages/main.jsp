<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
Hello = ${user}
Hello = ${user_name}
${filter_attr}
<br>
<form action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="logOut"/>
</form>
</body>
</html>
