package com.kosh.fullstack.repository;

import com.kosh.fullstack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
