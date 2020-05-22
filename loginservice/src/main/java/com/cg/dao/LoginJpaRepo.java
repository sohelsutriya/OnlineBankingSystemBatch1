package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.LoginCredentials;

public interface LoginJpaRepo extends JpaRepository<LoginCredentials,Integer> {

}
