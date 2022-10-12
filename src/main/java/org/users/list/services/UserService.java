package org.users.list.services;

import org.users.list.dtos.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface UserService extends Service<UserDTO> {

    UserDTO getUserByLogin(String login)  throws SQLException, IOException;
}
