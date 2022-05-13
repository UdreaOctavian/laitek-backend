package com.laitek.backend.repositories;

import com.laitek.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);

    @Query(value = "SELECT u " +
            "FROM User u " +
            "WHERE u.username = :username ")
    User getByUsername(@Param("username") String username);
}