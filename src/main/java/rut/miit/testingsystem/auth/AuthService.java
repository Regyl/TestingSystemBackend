package rut.miit.testingsystem.auth;

import org.springframework.stereotype.Service;

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

    public void register(RegisterDTORequest registerDTORequest) {
        if( isExists(registerDTORequest.getLogin()))
            throw new UserAlreadyExists();
        registerDTORequest.setPassword("{noop}"+registerDTORequest.getPassword());
        userRepository.save(new User(registerDTORequest));
        authorityRepository.save(new Authority(registerDTORequest));
    }
}
