package Heroku.Project.Controller;

import Heroku.Project.Entity.User;
import Heroku.Project.Repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


@PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/get/all")
    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }

}

