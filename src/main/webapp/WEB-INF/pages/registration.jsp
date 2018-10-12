<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="/static/images/favicon.ico"/>
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
                <t:registration_form registrationInfo="${registrationInfo}"/>
            </main><!-- .content -->
        </div><!-- .container-->

        <t:left_sidebar/>

    </div><!-- .middle-->

</div><!-- .wrapper -->

<t:footer/>

</body>
</html>
