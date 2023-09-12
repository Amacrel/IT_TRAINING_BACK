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

        String role = String.valueOf(user.get_user_role());

        return User
                .withUsername(user.get_user_firstname() + " " + user.get_user_lastname())
                .password(String.valueOf(user.get_user_password()))
                .roles(role).build();
    }
}
