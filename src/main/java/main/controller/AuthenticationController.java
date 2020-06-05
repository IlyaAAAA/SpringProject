package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.User;
import main.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/signUp")
  public String signUp(@RequestBody User user) {
    userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), Collections.singletonList("ROLE_USER")));
    return "authentication";
  }

  @GetMapping("userInfo")
  @ResponseBody
  public User getUser(Principal principal) {
    if (principal == null) {
      return null;
    }

       return userRepository.findByUsername(principal.getName()).get();
  }


}
