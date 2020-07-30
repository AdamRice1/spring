package com.Services;
import com.Model.Response.UserResponse;
import com.Model.Users;
import com.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<UserDto> getUsers(int page, int limit);

    UserDto createUser(UserDto userdto);

    UserResponse getUser(Long id);

    UserResponse getUsersByEmail(String email);

    UserResponse updateUser(Users user);

    void deleteUser(Long id);

    List<UserResponse> getAllUsers();
}
