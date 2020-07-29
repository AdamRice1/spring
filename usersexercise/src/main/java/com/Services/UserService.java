package com.Services;
import com.Model.Users;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getUsers();

    void createUser(Users user);

    Optional<Users> getUser(Long id);

    Optional<Users> getUsersByEmail(String email);

    void updateUser(Users user);

    void deleteUser(Long id);
}
