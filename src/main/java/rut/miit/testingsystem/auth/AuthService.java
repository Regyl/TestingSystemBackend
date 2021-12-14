package rut.miit.testingsystem.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.auth.user.UserRepository;
import rut.miit.testingsystem.auth.user.dto.request.UserDto;
import rut.miit.testingsystem.exception.UserAlreadyExistsException;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }

    public boolean isExists(String username) {
        return userRepository.existsById(username);
    }

    public void saveUser(UserDto registerRequest) {
        if(isExists(registerRequest.getLogin()))
            throw new UserAlreadyExistsException();
        userRepository.save(new User(registerRequest));
    }
}
