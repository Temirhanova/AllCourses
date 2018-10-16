<%@attribute name="user" required="true" type="ru.innopolis.stc.bean.User" %>
<div class="user_state">
    <%
        String outLogin = "";

        if (user == null) {
            outLogin = "<a class=\"btn btn-outline-success\" href=\"/login\" role=\"button\">Войти</a>\n" +
                    "<a class=\"btn btn-outline-success\" href=\"/registration\" role=\"button\">Регистрация</a>";
        } else {
            outLogin = "<a>" + user.getFirstName() + "</a><a class=\"btn btn-outline-success\" href=\"/login?action=exit\" role=\"button\">Выйти</a>";
        }
    %>
    <%=outLogin%>
</div>
<!-- .user_state -->
