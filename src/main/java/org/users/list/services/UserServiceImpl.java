package org.users.list.services;

import org.users.list.dtos.UserDTO;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private String getUsersByParams = "select * from users where (id = ? or ? is null) and (login = ? or ? is null) and " +
            "(name = ? or ? is null) and (email = ? or ? is null) and (age = ? or ? is null) and (registration = ? or ? is null)";
    private String addUser = "insert into users(login, name, email, age, registration) values (?, ?, ?, ?, ?)";
    private String updateUserById = "update users set login = ?, name = ?, email = ?, age = ?, registration = ? where id = ?";
    private String deleteUserById = "delete from users where id = ?";


    private void fullFillStatement(PreparedStatement stat, Map<String, String> params) throws SQLException {
        if (params.containsKey("id")) {
            stat.setInt(1, Integer.parseInt(params.get("id")));
            stat.setInt(2, Integer.parseInt(params.get("id")));
        } else {
            stat.setNull(1, Types.NULL);
            stat.setNull(2, Types.NULL);
        }
        if (params.containsKey("login")) {
            stat.setString(3, params.get("login"));
            stat.setString(4, params.get("login"));
        } else {
            stat.setNull(3, Types.NULL);
            stat.setNull(4, Types.NULL);
        }
        if (params.containsKey("name")) {
            stat.setString(5, params.get("name"));
            stat.setString(6, params.get("name"));
        } else {
            stat.setNull(5, Types.NULL);
            stat.setNull(6, Types.NULL);
        }
        if (params.containsKey("email")) {
            stat.setString(7, params.get("email"));
            stat.setString(8, params.get("email"));
        } else {
            stat.setNull(7, Types.NULL);
            stat.setNull(8, Types.NULL);
        }
        if (params.containsKey("age")) {
            stat.setInt(9, Integer.parseInt(params.get("age")));
            stat.setInt(10, Integer.parseInt(params.get("age")));
        } else {
            stat.setNull(9, Types.NULL);
            stat.setNull(10, Types.NULL);
        }
        if (params.containsKey("registration")) {
            stat.setString(11, params.get("registration"));
            stat.setString(12, params.get("registration"));
        } else {
            stat.setNull(11, Types.NULL);
            stat.setNull(12, Types.NULL);
        }
    }

    @Override
    public List<UserDTO> getEntities(Map<String, String> params) throws SQLException, IOException {
        try(Connection con = ServiceProvider.getConnection()) {
            PreparedStatement stat = con.prepareStatement(getUsersByParams);
            fullFillStatement(stat, params);
            ResultSet result = stat.executeQuery();
            LinkedList<UserDTO> users = new LinkedList<>();
            while (result.next()) {
                UserDTO user = new UserDTO(result.getInt(1), result.getString(2), result.getString(3),
                        result.getString(4), result.getInt(5), result.getString(6));
                users.add(user);
            }
            return users;
        }
    }

    private void setNotIdColumns(PreparedStatement stat, UserDTO entity) throws SQLException {
        stat.setString(1, entity.getLogin());
        stat.setString(2, entity.getName());
        stat.setString(3, entity.getEmail());
        stat.setInt(4, entity.getAge());
        stat.setString(5, entity.getRegistration());
    }

    @Override
    public void addEntity(UserDTO entity) throws SQLException, IOException {
        try(Connection con = ServiceProvider.getConnection()) {
            PreparedStatement stat = con.prepareStatement(addUser);
            setNotIdColumns(stat, entity);
            stat.executeQuery();
        }
    }

    @Override
    public void updateEntity(UserDTO entity) throws SQLException, IOException {
        try(Connection con = ServiceProvider.getConnection()) {
            PreparedStatement stat = con.prepareStatement(updateUserById);
            setNotIdColumns(stat, entity);
            stat.setInt(6, entity.getId());
            stat.executeQuery();
        }
    }

    @Override
    public void deleteEntity(Integer id) throws SQLException, IOException {
        try(Connection con = ServiceProvider.getConnection()) {
            PreparedStatement stat = con.prepareStatement(deleteUserById);
            stat.setInt(1, id);
            stat.executeQuery();
        }
    }
}
