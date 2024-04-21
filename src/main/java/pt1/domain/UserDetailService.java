package pt1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class implements the UserDetailsService interface and provides the
 * implementation
 * for loading user details by username.
 */
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository repository;

    /**
     * Constructs a new UserDetailService with the specified UserRepository.
     *
     * @param userRepository the UserRepository to be used for retrieving user
     *                       details.
     */
    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    /**
     * Loads the user details for the given username.
     *
     * @param username the username of the user to load.
     * @return the UserDetails object representing the loaded user details.
     * @throws UsernameNotFoundException if the user with the given username is not
     *                                   found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}
