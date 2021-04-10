package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {
	
	@Query("SELECT J FROM jedi J WHERE J.nome = :nome")
	
	List<Jedi> findByNome(String nome);
	
	
	@Query("SELECT mentor.nome AS JEDI_NOME, mentor.status AS JEDI_STATUS, jedi.nome AS APRENDIZ_NOME, jedi.status AS APRENDIZ_STATUS FROM padawan.jedi jedi JOIN padawan.jedi mentor ON mentor.id = jedi.mentor WHERE mentor.status = :status")
	List<Jedi> findJediAndAprenticeByStatus(String status);
	
    
	@Query("SELECT jedi.nome AS NOME, jedi.status AS STATUS, jedi.midichlorians AS MIDICHLORIANS FROM padawan.jedi	jedi WHERE jedi.midichlorians > 9000 AND jedi.status = :status")
	List<Jedi> findJediByMidichloriansAndStatus(int midichlorians, String status);
	
	@Query("SELECT jedi.status AS STATUS, COUNT(jedi.status) AS TOTAL FROM padawan.jedi	jedi GROUP BY jedi.status")
	List<Jedi> countStatus();
	
	@Query("SELECT * FROM padawan.jedi jedi WHERE jedi.nome = :nome")
	List<Jedi> findJediByNome(String nome);
}
