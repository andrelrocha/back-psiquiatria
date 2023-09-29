package jr.acens.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jr.acens.api.domain.user.UserRepository;

@Service
public class AuthenticateService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /* DE ALGUMA FORMA TEM QUE PASSAR O ROLE EM USERDETAILS
        return new User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + user.getAuthorities())
        );
         */


        return userRepository.findByLogin(username);
    }
}
