package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionamentoJediRepository extends JpaRepository<RelacionamentoJedi, Integer> {
	
	
	@Query(value = "select * from relacionamento_jedi order by id_mentor" , nativeQuery = true)
	List<RelacionamentoJedi> consultarMestreEAprendiz();

}
