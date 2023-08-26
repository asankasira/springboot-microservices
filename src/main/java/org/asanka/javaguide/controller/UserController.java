package org.asanka.javaguide.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.asanka.javaguide.dto.UserDTO;
import org.asanka.javaguide.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDto) {
        UserDTO savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable("id") Long userId) {
        UserDTO userDto = userService.getUser(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,
                           @RequestBody @Valid UserDTO dto) {
      UserDTO updated = userService.updateUser(userId, dto);
      return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User " + userId + " successfully deleted");
    }
}
