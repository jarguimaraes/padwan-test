package com.padwan.test.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.padwan.test.entity.Jedi;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {
	
	@Query(value = "select * from jedi where jedi.midichlorians >= 9000", nativeQuery = true)
	List<Jedi> findAllJediWithGoodPower();
	
	@Query(value = "select * from jedi where jedi.mestre_jedi is not null", nativeQuery = true)
	List<Jedi> findAllApprentices();
	
	@Query(value = "select count(id) as Quantity, jedi.status as Status from jedi group by jedi.status", nativeQuery = true)
	List<groupStatus> countsJedisByStatus();
}
