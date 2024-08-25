package io.orangetech.auth.controller.service;

import io.orangetech.auth.controller.entity.*;
import io.orangetech.auth.controller.repository.AuthRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class AuthService {


    @ConfigProperty(name="mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "com.ard333.quarkusjwt.jwt.duration")
    Long duration;

    @Inject
    AuthRepository authRepository;

    @Inject
    PasswordEncoder passwordEncoder;


    Logger LOG = LoggerFactory.getLogger(AuthService.class);

    @Transactional
    public Optional<User> registerUser(UserResponse userResponse){
        Optional<User> user = authRepository.findByEmail(userResponse.getEmail());
        if(user.isPresent()){
            throw new RuntimeException("Account is already created");
        }
        User newUser = new User();
        newUser.setEmail(userResponse.getEmail());
        newUser.setPassword(passwordEncoder.encode(userResponse.getPassword()));
        newUser.setUsername(userResponse.getUsername());
        newUser.setRole(Roles.USER);
        authRepository.persist(newUser);
        LOG.info("Account  {} is Created Successfully ", newUser.getEmail());
        return null;
    };


    @Transactional
    public AccessToken authenticateUser(LoginResponse loginResponse) throws Exception {
        Optional <User> user = authRepository.findByEmail(loginResponse.getEmail());
        if (user.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        boolean isPasswordTrue = user.get().getPassword().equals(passwordEncoder.encode(loginResponse.getPassword()));
        LOG.info("{}",isPasswordTrue);
        if(!isPasswordTrue){
            //String username, Roles roles, Long duration, String issuer
            throw new RuntimeException("Wrong email or password");
        }
        return new AccessToken(TokenUtils.generateToken(user.get().getUsername(), user.get().getRole(), duration, issuer));
    }
}
