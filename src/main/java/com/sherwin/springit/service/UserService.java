package com.sherwin.springit.service;

import com.sherwin.springit.domain.User;
import com.sherwin.springit.repository.RoleRepository;
import com.sherwin.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

/**
 * Register
 * Save the new user
 * Send Activation Email
 * Optional<User> findById(Long id)
 */

//@Component
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleRepository roleRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,MailService mailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mailService = mailService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        String secret= "{bcrypt}" + encoder.encode(user.getPassword());
        user.setEnabled(false);
        user.setPassword(secret);
        user.setConfirmPassword(secret);
        user.addRole(roleRepository.findByName("ROLE_USER"));
        user.setActivationCode(UUID.randomUUID().toString());
        save(user);
        sendActivationEmail(user);
        return user;
    }

    public void save(User user){
        userRepository.save(user);
    }

    private void sendActivationEmail(User user){
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user){
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode){
        return userRepository.findByEmailAndActivationCode(email,activationCode);
    }

    @Transactional
    public void saveUsers(User... users){
        for (User user:users){
            logger.info("Saving user: "+user.getEmail());
            userRepository.save(user);
        }
    }

//    public void saveUsers(User... users){
//
//        //begin transaction
//        for (User user:users){
//            logger.info("Saving user: "+user.getEmail());
//            try{
//                userRepository.save(user);
//            }catch (Exception e){
//                // rollback transaction
//            }
//        }
//        // commit transaction
//    }

//    @Transactional(readOnly=true)
//    public Optional<User> findById(Long id){
//        return userRepository.findById(id);
//    }

}
