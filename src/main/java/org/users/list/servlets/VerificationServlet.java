package org.users.list.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.users.list.dtos.UserDTO;
import org.users.list.services.UserService;
import org.users.list.services.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class VerificationServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        UserDTO userDTO = null;
        try {
            userDTO = userService.getUserByLogin(req.getParameter("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userDTO == null) {
            pw.print("Such login wasn\'t found");
        } else if (!req.getParameter("password").equals(userDTO.getPassword())) {
            pw.print("Fault password");
        } else {
            pw.print("OK");
            req.getSession().setAttribute("login", userDTO.getLogin());
        }
    }
}
