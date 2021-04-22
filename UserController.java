
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;


    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/{id}")
    public Object getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/create")
    public void createUserByUsernamePassword(String username,
                                             String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userService.createeUser(user);
    }


    @GetMapping("/find/")
    public List<User> getAge(@RequestParam String name,
                                                @RequestParam("age") Integer age) {
        return userRepository.findAllByNameContainsAndAge(name, age);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @PostMapping
    public void createeUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        userService.createeUser(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }



    @PutMapping("/{id}")
    public void updateeUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateeUser(id, user);
    }


    @PatchMapping("/{id}")
    public User updateAge(@PathVariable Long id,
                              @RequestParam Integer age) {
        User user = (User) userRepository.findById(id).get();
        user.setAge(age);
        return userRepository.saveAndFlush(user);
    }



}
