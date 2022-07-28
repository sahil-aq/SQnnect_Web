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
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    @RequestMapping(value = "/process_register", method = RequestMethod.GET)
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }
    
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
