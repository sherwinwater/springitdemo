package com.sherwin.springit.service;

import com.sherwin.springit.domain.User;
import com.sherwin.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return user;
    }

    public void save(User user){
        userRepository.save(user);
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

    @Transactional(readOnly=true)
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

}
