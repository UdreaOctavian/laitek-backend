package com.laitek.backend.services;

import com.laitek.backend.dtos.UserDTO;
import com.laitek.backend.dtos.builders.UserBuilder;
import com.laitek.backend.entities.User;
import com.laitek.backend.repositories.UserRepository;
import com.laitek.backend.security.AESEncrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private AESEncrypt aesEncrypt;
    private static final String secretKey = "secretkey";

    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserBuilder::toUserDTO).collect(Collectors.toList());
    }

    public UserDTO saveOrUpdate(UserDTO userDTO) {
        User user = UserBuilder.toEntity(userDTO);

        try {
            String decryptedPassword = AESEncrypt.decrypt(user.getPassword(), secretKey);

            if (user.getPassword() != null) {

                String encryptedPassword = AESEncrypt.encrypt(user.getPassword(), secretKey);
                user.setPassword(encryptedPassword);
                List<User> users = userRepository.findAll();
                if (users.isEmpty())
                    user.setIs_admin(true);
                userRepository.save(user);
                return UserBuilder.toUserDTO(user);
            } else {
                throw new Exception("Null password exception");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO getById(Long id) {
        User user = userRepository.getById(id);
        User u = new User(user.getId(), user.getUsername(), AESEncrypt.decrypt(user.getPassword(), secretKey), user.getName(), user.getIs_admin());
        return UserBuilder.toUserDTO(u);
    }

    public UserDTO userLogIn(String username, String password) {
        User user = userRepository.getByUsername(username);
        System.out.println(user.toString());
        String decryptedPassword = AESEncrypt.decrypt(user.getPassword(), secretKey);

        if (user != null) {
            if (decryptedPassword.equals(password))
                return UserBuilder.toUserDTO(user);
            else throw new IllegalStateException("Wrong password");
        } else {
            throw new IllegalStateException("Username <" + user.getUsername() + "does not exist in database");
        }
    }
}
