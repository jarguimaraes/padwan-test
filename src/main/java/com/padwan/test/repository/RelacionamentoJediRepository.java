package com.padwan.test.repository;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionamentoJediRepository extends JpaRepository<RelacionamentoJedi, Integer> {

}
