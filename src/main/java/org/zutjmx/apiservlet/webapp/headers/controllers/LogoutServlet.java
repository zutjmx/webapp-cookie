package org.zutjmx.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zutjmx.apiservlet.webapp.headers.services.LoginService;
import org.zutjmx.apiservlet.webapp.headers.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        Optional<String> username = loginService.getUsername(req);

        if (username.isPresent()) {
            Cookie usernameCookie = new Cookie("username","");
            usernameCookie.setMaxAge(0);
            resp.addCookie(usernameCookie);
        }

        resp.sendRedirect(req.getContextPath() + "/login.html");

    }
}
