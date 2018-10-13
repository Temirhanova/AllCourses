<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="/static/images/favicon.ico"/>
    <meta charset="utf-8"/>
    <title>Регистрация</title>
    <t:bootstrap/>

</head>

<body>
<t:header user="${user}"/>

<div class="container-fluid">
    <div class="row">
        <t:left_sidebar/>
        <div class="col-10 m-2">
            <main>
                <%-- Основное содержимое страницы --%>
                    <t:registration_form registrationInfo="${registrationInfo}"/>
            </main>
        </div>
    </div>
</div>
<t:footer/>

</body>
</html>
