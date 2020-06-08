package fr.florian.demo.service;

import fr.florian.demo.modele.User;
import fr.florian.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() { return (List<User>) userRepository.findAll(); }
}

