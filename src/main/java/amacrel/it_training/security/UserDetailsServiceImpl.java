package amacrel.it_training.security;

import amacrel.it_training.entity._User;
import amacrel.it_training.repository._UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private _UserRepository gestionUserDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        _User user = gestionUserDao.findUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException(String.format("User %s not found", username));

        String[] roles = user.getRoles().stream().map(u->u.getRights()).toArray(String[]::new);
        return User
                .withUsername(user.get_user_email())
                .password(user.get_user_password())
                .roles(roles).build();
    }
}
