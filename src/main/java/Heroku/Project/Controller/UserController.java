package Heroku.Project.Controller;

import Heroku.Project.Config.AppPasswordConfig;
import Heroku.Project.Entity.User;
import Heroku.Project.Repo.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

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
@CrossOrigin(origins = "http://localhost:3000")
    public User createUser(@RequestBody User user) {
        user.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
        user.setCreationDate(LocalDateTime.now());
        return userRepository.save(user);
    }


    @GetMapping("/get/all")
    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @PutMapping("/edit/{id}")
    public void editUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        user.setEmail(updatedUser.getEmail());

        userRepository.save(user);
    }

}


