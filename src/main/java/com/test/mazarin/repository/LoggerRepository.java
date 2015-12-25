package com.test.mazarin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.mazarin.entity.Log;

public interface LoggerRepository extends JpaRepository<Log, Integer>{

}
