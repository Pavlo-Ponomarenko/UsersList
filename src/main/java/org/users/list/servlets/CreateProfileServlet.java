package org.users.list.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.users.list.dtos.UserDTO;
import org.users.list.services.UserService;
import org.users.list.services.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CreateProfileServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, String> params = new HashMap<>();
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        try {
            userService.addEntity(new UserDTO(login, password, email, Integer.parseInt(age), formatter.format(date)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
