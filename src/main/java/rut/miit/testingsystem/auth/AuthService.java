package rut.miit.testingsystem.auth;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.auth.authority.Authority;
import rut.miit.testingsystem.auth.authority.AuthorityRepository;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.auth.user.dto.request.UserDTORegisterRequest;
import rut.miit.testingsystem.auth.user.UserRepository;
import rut.miit.testingsystem.exception.UserAlreadyExistsException;

@Service
public class AuthService {
    final UserRepository userRepository;
    final AuthorityRepository authorityRepository;
    public AuthService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository=userRepository;
        this.authorityRepository=authorityRepository;
    }

    public boolean isExists(String username) {
        return userRepository.existsById(username);
    }

    public void register(UserDTORegisterRequest userDTORegisterRequest) {
        if( isExists(userDTORegisterRequest.getLogin()))
            throw new UserAlreadyExistsException();
        userDTORegisterRequest.setPassword("{noop}"+ userDTORegisterRequest.getPassword());
        userRepository.save(new User(userDTORegisterRequest));
        authorityRepository.save(new Authority(userDTORegisterRequest));
    }
}
