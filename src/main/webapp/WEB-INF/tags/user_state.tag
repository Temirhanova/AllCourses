<%@ tag import="java.io.PrintWriter" %>
<%@attribute name="user" required="true" type="ru.innopolis.stc.pojo.User" %>
<div class="user_state">
    <%
        PrintWriter pw = response.getWriter();
        if (user == null) {
            pw.print("<a href = \"/login\">Войти</a>");
            pw.print("<a href = \"/registration\">Регистрация</a>");
        } else {
            pw.print("<a>" + user.getFirstName() + "</a>");
            pw.print("<a href = \"/login?action=exit\">Выход</a>");
        }
    %>
</div>
<!-- .user_state -->