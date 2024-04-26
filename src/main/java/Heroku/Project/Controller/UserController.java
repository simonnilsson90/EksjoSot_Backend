package Heroku.Project.Controller;

import Heroku.Project.Config.AppPasswordConfig;
import Heroku.Project.Entity.User;
import Heroku.Project.Repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{


    private final UserRepository userRepository;
    private final AppPasswordConfig appPasswordConfig;

    public UserController(UserRepository userRepository, AppPasswordConfig appPasswordConfig) {
        this.userRepository = userRepository;
        this.appPasswordConfig = appPasswordConfig;
    }


@PostMapping("/create")
    public User createUser(@RequestBody User user) {
        user.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        user.setCreationDate(LocalDateTime.now());
        return userRepository.save(user);
    }


    @GetMapping("/get/all")
    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }

}

