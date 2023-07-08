package com.kata.security.web.security.web.repositories;


import com.kata.security.web.security.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
