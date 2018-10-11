package ru.innopolis.stc.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartPage extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(StartPage.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Call do get");
        req.getRequestDispatcher("WEB-INF/pages/start_page.jsp").forward(req, resp);
    }
}