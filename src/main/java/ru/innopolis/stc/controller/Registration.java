package ru.innopolis.stc.controller;

import ru.innopolis.stc.daosql.UserDaoJDBC;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.User;
import ru.innopolis.stc.servicesInterfaces.UserManager;
import ru.innopolis.stc.servisces.UserManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {
    UserManager userManager;

    public Registration(UserManager userManager) {
        this.userManager = userManager;
    }

    public Registration() {
        userManager = new UserManagerImpl(new UserDaoJDBC(new DatabaseConnectionPool()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);

        req.setAttribute("registrationInfo", userManager.registration(null));
        req.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User(
                0,
                User.GUEST,
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("firstname"),
                req.getParameter("secondname")
        );

        req.setAttribute("registrationInfo", userManager.registration(user));
        req.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(req, resp);
    }
}