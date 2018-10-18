<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список курсов</title>
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
                <div>
                    <div class="container bs-docs-container">
                        <c:set var="cources" scope="request" value="${requestScope.get('getAllCourses')}"/>
                        <c:choose>
                            <c:when test="${cources.isEmpty()}">
                                <h1 class="text-center">В данный момент нет курсов</h1>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="cource" items="${cources}">
                                    <div class="card w-50">
                                        <div class="card-body">
                                            <h5 class="card-title">${cource.name}</h5>
                                            <p class="card-text">${cource.description}</p>
                                            <a href="#" class="btn btn-primary">Записаться</a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </main>
        </div>
    </div>
</div>
<t:footer/>

</body>
</html>