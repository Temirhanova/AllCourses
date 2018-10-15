<%@ tag import="ru.innopolis.stc.pojo.RegistrationInfo" %>
<%@ tag import="ru.innopolis.stc.pojo.User" %>
<%@attribute name="registrationInfo" required="true" type="ru.innopolis.stc.pojo.RegistrationInfo" %>
<div class="registration">
    <%
        int id = 0;
        int role = 0;
        String mail = "";
        String pass = "";
        String firstName = "";
        String secondName = "";
        String state = "";

        if (registrationInfo != null) {
            switch (registrationInfo.getInfo()) {
                case RegistrationInfo.REPEATED_MILE:
                    state = "Такой емайл уже сущестует.";
                    break;
                case RegistrationInfo.NOT_FILLED_FIELDS:
                    state = "Не все поля введены.";
                    break;
                case RegistrationInfo.SUCCESSFUL_REGISTRATION:
                    state = "Поздравляем с регистрацией";
                    break;
            }
            User user = registrationInfo.getUser();
            mail = user.getMail();
            pass = user.getPass();
            firstName = user.getFirstName();
            secondName = user.getSecondName();
        }
    %>
    <form method="post">
        <input name="firstname" placeholder="Имя" value="<%=firstName%>">
        <input name="secondname" placeholder="Фамилия" value="<%=secondName%>">
        <input name="email" placeholder="Е-мейл" value="<%=mail%>">
        <input name="password" type="password" placeholder="Пароль" value="<%=pass%>">
        <input type="submit" value="Зарегистрировать">
    </form>
    <div>
        <%=state%>
    </div>
</div>
<!-- .user_state -->