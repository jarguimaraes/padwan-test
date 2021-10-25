package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {
	    
	@Query(value = "SELECT * FROM jedi WHERE midichlorians > 9000" , nativeQuery = true)
	List<Jedi> consultarMidichlorians();
	
	@Query(value = ""
			+ "SELECT \r\n"
			+ "	CASE \r\n"
			+ "		status_enum \r\n"
			+ "	WHEN 0 THEN 'PADAWAN'\r\n"
			+ "	WHEN 1 THEN 'JEDI'\r\n"
			+ "	ELSE 'MESTRE JEDI'\r\n"
			+ "	END,\r\n"
			+ "	COUNT(*) AS quantidade \r\n"
			+ "FROM \r\n"
			+ "	jedi \r\n"
			+ "GROUP BY \r\n"
			+ "	status_enum\r\n"
			+ "ORDER BY \r\n"
			+ "	status_enum"
			, nativeQuery = true)
	List consultarPorCategoria();
	
	
}
