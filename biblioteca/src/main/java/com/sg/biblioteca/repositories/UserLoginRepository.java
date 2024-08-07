package com.sg.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.biblioteca.models.UserLogin;
import com.sg.biblioteca.models.Usuarios;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	UserLogin findByUsername(String username);
}
