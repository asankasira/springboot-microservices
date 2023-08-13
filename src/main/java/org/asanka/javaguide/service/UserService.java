package org.asanka.javaguide.service;

import org.asanka.javaguide.dto.UserDTO;
import org.asanka.javaguide.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);

    UserDTO getUser(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long userId, UserDTO dto);

    void deleteUser(Long userId);

}
