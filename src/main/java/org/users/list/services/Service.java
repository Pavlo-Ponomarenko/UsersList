package org.users.list.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Service<T> {

    List<T> getEntities(Map<String, String> params) throws SQLException, IOException;

    void addEntity(T entity) throws SQLException, IOException;

    void updateEntity(T entity) throws SQLException, IOException;

    void deleteEntity(Integer id) throws SQLException, IOException;
}
