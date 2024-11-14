package za.ac.tut.StillCooks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.tut.StillCooks.Model.StillCooksUser;
import za.ac.tut.StillCooks.Repository.UserRepo;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @PostMapping(value = "/req/signup", consumes = "application/json")
    public StillCooksUser createUser(@RequestBody StillCooksUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
