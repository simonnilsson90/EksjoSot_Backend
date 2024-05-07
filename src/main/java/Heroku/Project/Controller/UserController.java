package Heroku.Project.Controller;

import Heroku.Project.Config.AppPasswordConfig;
import Heroku.Project.Config.JwtProvider;
import Heroku.Project.Entity.User;
import Heroku.Project.Repo.UserRepository;
import Heroku.Project.Response.AuthResponse;
import Heroku.Project.Services.UserService;
import Heroku.Project.Services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImplementation customUserDetails;

    @Autowired
    private UserService userService;

    private final AppPasswordConfig appPasswordConfig;

    @Autowired
    private final AuthenticationManager authenticationManager;


    public UserController(UserRepository userRepository, AppPasswordConfig appPasswordConfig, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.appPasswordConfig = appPasswordConfig;
        this.authenticationManager = authenticationManager;
    }

@PostMapping("/create")
public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception {
    String email = user.getEmail();
    String password = user.getPassword();
    User isEmailExist = userRepository.findByEmail(email);
    if (isEmailExist != null) {
        throw new Exception("Email Is Already Used With Another Account");

    }
    User createdUser = new User();
    createdUser.setEmail(email);
    createdUser.setPassword(passwordEncoder.encode(password));
    createdUser.setCreationDate(LocalDateTime.now());

    User savedUser = userRepository.save(createdUser);
    userRepository.save(savedUser);
    Authentication authentication = new UsernamePasswordAuthenticationToken(email,password);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = JwtProvider.generateToken(authentication);


    AuthResponse authResponse = new AuthResponse();
    authResponse.setJwt(token);
    authResponse.setMessage("Register Success");
    authResponse.setStatus(true);
    return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);

}

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody User loginRequest) {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        System.out.println(username+"-------"+password);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();

        authResponse.setMessage("Login success");
        authResponse.setJwt(token);
        authResponse.setStatus(true);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }


    @GetMapping("/get/all")
    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }

}

