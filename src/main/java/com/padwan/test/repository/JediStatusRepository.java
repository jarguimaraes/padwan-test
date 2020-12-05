package com.padwan.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.padwan.test.entity.JediStatus;

@Repository
public interface JediStatusRepository extends JpaRepository<JediStatus, Integer> {

  @Query(value = "select js.id from jedi_status js where js.status = 'Mestre Jedi'", nativeQuery = true)
  Integer getMestreJediId();

  @Query(value = "SELECT js.id, js.status, COUNT(j.status_id)\n" + "FROM jedi_status js INNER JOIN\n" + "     jedi j\n"
      + "    ON j.status_id = js.id \n" + "GROUP BY js.id, js.status\n" + "order by js.id", nativeQuery = true)
  String[] getJedisPorCategoria();

}
