package com.padwan.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.padwan.test.entity.Jedi;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {

  @Query(value = "select j.* from jedi j where j.midichlorians > 9000", nativeQuery = true)
  List<Jedi> findJediMidichloriansMaiorQue();

  @Query(value = "select j.* from jedi j where j.midichlorians > 9000", nativeQuery = true)
  List<Jedi> findCountJedisPorCategoria();

  @Query(value = "SELECT M.NOME MENTOR, J.NOME JEDI, S.STATUS \n" + "  FROM JEDI M\n" + " INNER JOIN JEDI J \n"
      + "    ON J.jedi_mentor_id = M.ID\n" + " INNER JOIN jedi_status S \n"
      + "    ON S.ID = J.STATUS_ID", nativeQuery = true)
  String[] getJedisMentores();

}
