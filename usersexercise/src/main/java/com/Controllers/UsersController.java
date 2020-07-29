package com.Controllers;

import com.Model.Users;
import com.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UserService userservice;

    public UsersController(UserService userservice){
        this.userservice = userservice;
    }

    @GetMapping
    public List<Users> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "limit", defaultValue = "3") int limit){
        List<Users> returnValue = userservice.getUsers(page, limit);
        return returnValue;
    }

    @PostMapping
    public void createUser(@RequestBody Users user){
        userservice.createUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<Users> getUsers(@PathVariable Long id){
        Optional<Users> returnValue = userservice.getUser(id);

        return returnValue;
    }
    @GetMapping(path = "/email/{email}")
    public Optional<Users> getUsersByEmail(@PathVariable String email){
        Optional<Users> returnValue = userservice.getUsersByEmail(email);
        return returnValue;
    }

    @PutMapping
    public void updateUser(@RequestBody Users user){
      userservice.updateUser(user);

    }
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id){
        userservice.deleteUser(id);

    }

}
