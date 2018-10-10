<%--
  Created by IntelliJ IDEA.
  User: pd
  Date: 10.10.18
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="/static/images/favicon.ico"/>
    <title>Создание курса</title>
</head>
<body>
<form id="create-course" method="post" action="/course/create">
    <input type="text" name="name">Имя преподавателя</input><br>
    <input type="text" name="description">Описание курса</input><br>
    <input type="text" name="teacherId">ИД учителя</input><br>
    <input type="submit" name="Создать курс"/>
</form>
</body>
</html>