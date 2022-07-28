package com.trainee.sqnnect.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trainee.sqnnect.Models.User;
import com.trainee.sqnnect.Repository.UserRepository;
/**
 * 
 * @author Yash
 * @version 1.0
 */
@Controller
//@EnableCaching
public class AppController {
	@Autowired
    private UserRepository userRepo;
	@Autowired
	JdbcTemplate jdbcTemplate;
     
    @GetMapping("/start")
    public String viewHomePage() {
        return "index";
    }
    /**
     * Add a new handler method in the controller class to show the user registration form (sign up)
     * 
     */
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
/**a handler method in the controller class to process registration 
    
     */
    /**we use BCryptPasswordEncoder to encode the user’s password so the password itself it not 
     * stored in database (for better security) – only the hash value of the password is stored*/
    
    @RequestMapping(value = "/process_register", method = RequestMethod.GET)
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }
    
    /** we call the findAll() method on the UserRepository 
     * but we didn’t write that method. It is defined by the Spring Data JPA’s JpaRepository interface.*/
    
    
    @GetMapping("/users")
    //@Cacheable(value="users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
         
        return "users";
    }
//    @GetMapping("/Demo")
//    public ResponseEntity<Object> getAllUsers(){
//    	Object categories = jdbcTemplate.queryForList("select * from users");
//    	return new ResponseEntity<>(categories,HttpStatus.OK);
//    }
//    @GetMapping("/Demo")
//    public String view() {
//        return "Demo";
//    }
    @RequestMapping(value="/users/id",path="/users/id",method=RequestMethod.GET )
    public String  querybyId(Model model, @RequestParam(value="id") String id ) {

        return "Demo";
    }
}
