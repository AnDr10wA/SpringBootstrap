package com.kata.security.web.security.web.services;

import com.kata.security.web.security.web.model.Role;
import com.kata.security.web.security.web.model.User;
import com.kata.security.web.security.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncode) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncode;
    }
    @Override
    public User findById(Long id){
        return userRepository.getOne(id);
    }
    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void updateUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void saveUser(User user, Collection<Role> listRoles){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(listRoles);
        userRepository.save(user);
    }
    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
