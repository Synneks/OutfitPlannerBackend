package com.lid.outfitplannerbackend.persistence;

import com.lid.outfitplannerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User getByUsernameAndPassword(String username, String password);

    public User getByUsername(String username);
}