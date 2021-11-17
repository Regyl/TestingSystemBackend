package rut.miit.testingsystem.auth;

import org.jboss.logging.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.auth.authority.RoleRepository;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.auth.user.UserRepository;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;
import rut.miit.testingsystem.exception.UserAlreadyExistsException;

@Service
public class AuthService implements UserDetailsService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    private static final Logger log = Logger.getLogger(AuthService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    public boolean isExists(String username) {
        return userRepository.existsById(username);
    }

    public void saveUser(UserDTORegisterRequest registerRequest) {
        if(isExists(registerRequest.getLogin()))
            throw new UserAlreadyExistsException();
        userRepository.save(new User(registerRequest));
    }
}
