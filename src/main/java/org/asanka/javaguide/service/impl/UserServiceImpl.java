package org.asanka.javaguide.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.asanka.javaguide.dto.UserDTO;
import org.asanka.javaguide.entity.User;
import org.asanka.javaguide.exception.EmailAlreadyExistsException;
import org.asanka.javaguide.exception.ResourceNotFoundException;
import org.asanka.javaguide.mapper.UserMapper;
import org.asanka.javaguide.repository.UserRepository;
import org.asanka.javaguide.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMapping(User::getLastName, UserDTO::setSurname);
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        userRepository.findUserByEmail(dto.getEmail()).ifPresent(usr -> {
            throw new EmailAlreadyExistsException("Email is already in use");
        });
        User usr = UserMapper.INSTANCE.mapToUser(dto);
        User savedUser = userRepository.save(usr);
        return UserMapper.INSTANCE.mapToUserDto(savedUser);
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return UserMapper.INSTANCE.mapToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(usr -> modelMapper.map(usr, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO dto) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        User existingUser = UserMapper.INSTANCE.mapToUser(dto);
        existingUser.setId(userId);
        User updatedUsr = userRepository.save(existingUser);
        return UserMapper.INSTANCE.mapToUserDto(updatedUsr);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
