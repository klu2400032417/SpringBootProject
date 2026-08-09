package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Team;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
 List<Team> findByName(String name);
 List<Team> findByType(String type);
}
