package zw.co.footprint.kaguvi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.footprint.kaguvi.exception.ResourceNotFoundException;
import zw.co.footprint.kaguvi.model.User;
import zw.co.footprint.kaguvi.repository.UserRepository;
import zw.co.footprint.kaguvi.security.CurrentUser;
import zw.co.footprint.kaguvi.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}