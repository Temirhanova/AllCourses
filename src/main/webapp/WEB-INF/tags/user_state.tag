<%@attribute name="user" required="true" type="ru.innopolis.stc.pojo.User" %>
<div class="user_state">
    <%
        String outLogin = "";

        if (user == null) {
            outLogin = "<a href = \"/login\">Войти</a> <a href = \"/registration\">Регистрация</a>";
        } else {
            outLogin = "<a>" + user.getFirstName() + "</a><a href = \"/login?action=exit\">Выход</a>";
        }
    %>
    <%=outLogin%>
</div>
<!-- .user_state -->