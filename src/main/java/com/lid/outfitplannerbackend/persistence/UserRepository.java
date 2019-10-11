package com.lid.outfitplannerbackend.persistence;

import com.lid.outfitplannerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}