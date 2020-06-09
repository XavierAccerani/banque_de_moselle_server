package fr.florian.demo.controleur;

import fr.florian.demo.modele.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControleur {
    private final UserService userService;

    public UserControleur(final UserService userService) {
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserControleur {

    private final UserService userService;

    UserControleur(UserService userService) {
>>>>>>> matthieu-master
        this.userService = userService;
    }

    @GetMapping("/actuel")
    public LdapUserDetails getActuel(final Authentication authentication) {
        return (LdapUserDetails) authentication.getPrincipal();
    }

    @GetMapping
    @Secured("ROLE_ADMINS")
    public List<User> getAll() {
        return userService.findAll();
    }
}
