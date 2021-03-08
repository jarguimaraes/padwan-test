package com.padwan.test.repository;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, String> {

    @createNativeQuery("select jedi.mestre as Mestre, jedi.nome as Aprendiz from jedi where jedi.status = 'Mestre Jedi'")
    List<Jedi> findByMestre(@Param("mestre") String mestre, @Param("nome") String nome);

    @QuecreateNativeQueryry("select  jedi.nome, jedi.midichlorians from jedi where jedi.midichlorians > 9000")
    List<Jedi> findByMidichlorians(@Param("nome") String nome, @Param("midichkirians") Integer midichkirians);

    @createNativeQuery("select  COUNT(jedi.status) AS Qtd_JEDI  from jedi where jedi.status = 'Jedi' ")
    List<Jedi> findByStatus(@Param("status") String status);

    default List<JediDTO> findByMestre() {
        List<Jedi> jedis = findByMestre(null, null);
        List<JediDTO> listJedis = new ArrayList<>();
        jedis.forEach(it -> listJedis.add(new JediDTO(it)));
        return listJedis;

    }

}
