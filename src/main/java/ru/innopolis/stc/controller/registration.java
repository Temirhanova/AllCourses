package ru.innopolis.stc.controller;

import ru.innopolis.stc.daosql.UserDaoJDBC;
import ru.innopolis.stc.pojo.User;
import ru.innopolis.stc.servicesInterfaces.UserManager;
import ru.innopolis.stc.servisces.UserManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registration extends HttpServlet {
    UserManager userManager;

    public registration(UserManager userManager) {
        this.userManager = userManager;
    }

    public registration() {
        this.userManager = new UserManagerImpl(new UserDaoJDBC());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGetPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGetPost(req, resp);
    }

    private void doGetPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(req, resp);
    }
}