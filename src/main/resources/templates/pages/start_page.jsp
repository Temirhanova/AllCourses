<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Главная страница</title>
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
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus
                eu,
                aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque
                vitae pede.
                Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec,
                mollis non,
                nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor
                condimentum.
                Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et
                malesuada
                lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.
            </main>
        </div>
    </div>
</div>


</div>
<%--<div class="row container-fluid">--%>
<%--<div>--%>
<%--<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">--%>
<%--<ul class="nav nav-pills flex-column">--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link active" href="#">Overview <span class="sr-only">(current)</span></a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="#">Reports</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="#">Analytics</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="#">Export</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</nav>--%>
<%--</div>--%>
<%--<div>--%>
<%--<main class="content">--%>
<%--<strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,--%>
<%--aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.--%>
<%--Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,--%>
<%--nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum.--%>
<%--Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada--%>
<%--lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.--%>
<%--</main><!-- .content -->--%>
<%--</div><!-- .container-->--%>
<%--</div>--%>


<%--&lt;%&ndash;<t:left_sidebar/>&ndash;%&gt;--%>

<%--<div class="container-fluid">--%>
<%--<main class="content">--%>
<%--<strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,--%>
<%--aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.--%>
<%--Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,--%>
<%--nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum.--%>
<%--Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada--%>
<%--lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.--%>
<%--</main><!-- .content -->--%>
<%--</div>--%>

<t:footer/>

</body>
</html>
