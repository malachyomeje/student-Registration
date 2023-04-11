package com.example.demo.repository;

import com.example.demo.dtos.request.StudentDots;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Users,Long> {
    Optional <Users> findByEmail (String email);
    Optional <Users> findByEmailAndName (String email,String name);
    Optional<Users>findByName(String name);
}
