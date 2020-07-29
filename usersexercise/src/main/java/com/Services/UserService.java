package com.Services;
import com.Model.Users;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> getUsers(int page, int limit);

    void createUser(Users user);

    Optional<Users> getUser(Long id);

    Optional<Users> getUsersByEmail(String email);

    void updateUser(Users user);

    void deleteUser(Long id);

}
