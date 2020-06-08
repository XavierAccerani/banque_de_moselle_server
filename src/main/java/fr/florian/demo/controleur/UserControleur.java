package fr.florian.demo.controleur;

import fr.florian.demo.modele.User;
import fr.florian.demo.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserControleur {

    private final UserService userService;

    UserControleur(UserService userService) {
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
