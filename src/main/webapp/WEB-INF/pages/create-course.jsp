<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Создание курса</title>
    <t:bootstrap/>
</head>
<body>

<t:header/>

<div class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content">
    <form id="create-course" method="post" action="/course/create">
        <div class="form-group">
            <label for="name">Имя преподавателя</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Введите имя ...">
        </div>
        <div class="form-group">
            <label for="description">Описание курса</label>
            <textarea class="form-control" rows="3" id="description" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="teacherId">ИД преподователя</label>
            <input type="text" class="form-control" id="teacherId" name="teacherId">
        </div>
        <input type="submit" name="Создать курс"/>
    </form>
</div>

<t:footer/>

</body>
</html>