package com.example.pharmacieapi.service;

import com.example.pharmacieapi.entity.User;
import com.example.pharmacieapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public int registerNewUserServiceMethod(String fname, String lname, String email, String password){
        return userRepository.registerNewUser(fname,lname,email,password);
    }
    // End Of Register New User Service Method.


    public List<String> checkUserEmail(String email){
        return userRepository.checkUserEmail(email);
    }
    // End Of Check User Email Services Method.

    public String checkUserPasswordByEmail(String email){
        return userRepository.checkUserPasswordByEmail(email);
    }
    // End Of Check User Password Services Method.

    public User getUserById(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null ;

    }

    public User getUserDetailsByEmail(String email){
        return userRepository.getUserDetailsByEmail(email).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  getUserDetailsByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", username));
        }
        else{
            return (UserDetails) user;
        }
    }
    // End Of Get User Details By Email.
}
