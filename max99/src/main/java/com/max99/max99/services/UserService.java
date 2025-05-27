package com.max99.max99.services;


import com.max99.max99.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

   List<UserDTO> getAllUsers();
   UserDTO createNewUser(UserDTO inputUser);
   UserDTO getUserById(Long userId);
   UserDTO updateUser(UserDTO inputUser, Long UserId);

}
