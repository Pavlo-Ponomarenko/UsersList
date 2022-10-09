package org.users.list.converters;

import org.users.list.dtos.UserDTO;
import org.users.list.views.UserView;

public class UserConverterImpl implements UserConverter {
    @Override
    public UserView fromDTOtoView(UserDTO userDTO) {
        UserView userView = new UserView(userDTO.getId(), userDTO.getLogin(), userDTO.getName(),
                userDTO.getEmail(), userDTO.getAge(), userDTO.getRegistration());
        return userView;
    }

    @Override
    public UserDTO fromViewToDTO(UserView userView) {
        UserDTO userDTO = new UserDTO(userView.getId(), userView.getLogin(), userView.getName(),
                userView.getEmail(), userView.getAge(), userView.getRegistration());
        return userDTO;
    }
}
