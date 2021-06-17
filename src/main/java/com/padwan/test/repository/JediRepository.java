package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {

	//Listar todos Jedis cujo midichlorians sejam acima de 9000;
		@Query(value = "select * from jedi where jedi.midichlorians >= 9000", nativeQuery = true)
		List<Jedi> findAllPowerMAx();

		//Listar todos os mestres Jedis e seus aprendizes;
		@Query(value = "select * from jedi where jedi.mentor is not null", nativeQuery = true)
		List<Jedi> findAllAprendizes();


		//Listar por categoria, quantos sÃ£o os Jedis;
		@Query(value = "select count(id) as Quantidade, jedi.status as Status from jedi group by jedi.status", nativeQuery = true)
		List<StatusRepository> countStatus();

}
