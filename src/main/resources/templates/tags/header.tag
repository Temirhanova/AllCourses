<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="user" required="true" type="ru.innopolis.stc.bean.User" %>
<header class="header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Эчпочмак</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Учителя</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ученики</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">О нас</a>
                </li>
                <li class="nav-item">
                    <t:user_state user="${user}"/>

                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Искать" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
            </form>
        </div>
    </nav>

</header>
<!-- .header-->