package com.Services.Implementations;

import com.Services.UserService;
import com.dao.UserRepository;
import org.springframework.stereotype.Service;
import com.Model.Users;
import java.util.List;
import java.util.*;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userrepository;

    public UserServiceImplementation(UserRepository userrepository) {
        this.userrepository = userrepository;
    }


    @Override
    public List<Users> getUsers() {
        List<Users> returnValue = new ArrayList<Users>();

        returnValue = (List<Users>) userrepository.findAll();

        return returnValue;
    }

    @Override
    public void createUser(Users user) {
        userrepository.save(user);
    }

    @Override
    public Optional<Users> getUser(Long id) {
        Optional<Users> returnValue = userrepository.findById(id);
        return returnValue;
    }

    @Override
    public Optional<Users> getUsersByEmail(String email) {
        Optional<Users> returnValue = Optional.ofNullable(userrepository.findByEmail(email));
        return returnValue;
    }

    @Override
    public void updateUser(Users user) {
        ArrayList<Users> users = (ArrayList<Users>) userrepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                userrepository.save(user);
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        userrepository.deleteById(id);
    }
}
