package org.users.list.tags;

import jakarta.servlet.jsp.tagext.TagSupport;
import org.users.list.dtos.UserDTO;
import org.users.list.services.UserService;
import org.users.list.services.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UsersTableTag extends TagSupport {
    private UserService userService = new UserServiceImpl();

    @Override
    public int doStartTag() {
        try {
            List<UserDTO> users = userService.getAllEntities();
            for (UserDTO user : users) {
                pageContext.getOut().println("<tr>");
                pageContext.getOut().println("<td>");
                pageContext.getOut().println(user.getId());
                pageContext.getOut().println("</td>");
                pageContext.getOut().println("<td>");
                pageContext.getOut().println(user.getLogin());
                pageContext.getOut().println("</td>");
                pageContext.getOut().println("<td>");
                pageContext.getOut().println(user.getEmail());
                pageContext.getOut().println("</td>");
                pageContext.getOut().println("<td>");
                pageContext.getOut().println(user.getAge());
                pageContext.getOut().println("</td>");
                pageContext.getOut().println("<td>");
                pageContext.getOut().println(user.getRegistration());
                pageContext.getOut().println("</td>");
                pageContext.getOut().println("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
