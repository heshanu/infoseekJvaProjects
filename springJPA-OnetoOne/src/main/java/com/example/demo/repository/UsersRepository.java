package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
