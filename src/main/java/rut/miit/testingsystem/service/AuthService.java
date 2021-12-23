package rut.miit.testingsystem.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.User;
import rut.miit.testingsystem.repository.UserRepository;
import rut.miit.testingsystem.api.controller.dto.request.UserDto;
import rut.miit.testingsystem.exception.UserAlreadyExistsException;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        User user = new User(registerRequest, passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }
}
