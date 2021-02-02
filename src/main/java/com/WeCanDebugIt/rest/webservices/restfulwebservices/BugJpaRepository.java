package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugJpaRepository extends JpaRepository<Bug,Long>{
    List<Bug> findByUsername(String username);
}
