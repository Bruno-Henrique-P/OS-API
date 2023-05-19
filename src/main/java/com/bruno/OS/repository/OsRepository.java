package com.bruno.OS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.OS.domain.OS;



@Repository
public interface OsRepository extends JpaRepository<OS,Integer> {
	
}
