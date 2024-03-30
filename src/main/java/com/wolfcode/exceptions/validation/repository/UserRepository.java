package com.wolfcode.exceptions.validation.repository;

import com.wolfcode.exceptions.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
