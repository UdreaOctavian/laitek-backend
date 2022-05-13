package com.laitek.backend.controllers;
import com.laitek.backend.dtos.UserDTO;
import com.laitek.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO saveOrUpdate(@RequestBody UserDTO userDTO) {
        return userService.saveOrUpdate(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/{username}/{password}")
    public UserDTO userLogIn(@PathVariable String username, @PathVariable String password) {
        return userService.userLogIn(username, password);
    }
}
