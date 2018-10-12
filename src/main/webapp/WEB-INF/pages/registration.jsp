<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Все курсы</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<div class="wrapper">

    <t:header user="${user}"/>

    <div class="middle">
        <div class="container">
            <main class="content">
                <div class="registration">
                    <form method="post">
                        <input name="firstname" placeholder="Имя">
                        <input name="secondname" placeholder="Фамилия">
                        <input name="email" placeholder="Е-мейл">
                        <input name="password" type="password" placeholder="Пароль">
                        <input type="submit" value="Зарегистрировать">
                    </form>
                </div>

            </main><!-- .content -->
        </div><!-- .container-->

        <t:left_sidebar/>

    </div><!-- .middle-->

</div><!-- .wrapper -->

<t:footer/>

</body>
</html>
