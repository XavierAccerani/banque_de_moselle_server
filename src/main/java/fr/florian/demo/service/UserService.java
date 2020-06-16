package fr.florian.demo.service;

import fr.florian.demo.modele.User;
import fr.florian.demo.repo.UserRepository;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * findOne dans le repo. ldapRepository prend en paramètre une "query"
     * Cette dernière doit être construite à l'aide de LdapQueryBuilder
     * @param id
     * @return Optional<User>
     */
    public Optional<User> findByUid(final String id) {
        LdapQuery query = LdapQueryBuilder.query()
                                          .where("objectclass")
                                          .is("person")
                                          .and("uid")
                                          .is(id);
        return userRepository.findOne(query);
    }
}
