package Heroku.Project.Controller;

import Heroku.Project.Config.AppPasswordConfig;
import Heroku.Project.Tables.User;
import Heroku.Project.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRepository userRepository;
    private final AppPasswordConfig appPasswordConfig;

    @Autowired
    public UserController(UserRepository userRepository, AppPasswordConfig appPasswordConfig) {
        this.userRepository = userRepository;
        this.appPasswordConfig = appPasswordConfig;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        System.out.println("Received user: " + user.toString());
        user.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }


}
