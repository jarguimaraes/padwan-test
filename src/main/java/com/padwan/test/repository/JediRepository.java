package com.padwan.test.repository;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.dto.MestreEAprendizDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {

//    @Query(value = "select AVG(s.salary) as average, MAX(s.salary) as maximum, MIN(s.salary) as minimum from employees e \n" +
//            "\n" +
//            "inner join salaries s on s.emp_no = e.emp_no\n" +
//            "\n" +
//            "where gender = ?1", nativeQuery = true)
//    EmployeeSalaryDTO getAverageMaxAndMinSalaryByGender(String gender);

    @Query(value = "select mestre, aprendizes from MestreEAprendizDTO ", nativeQuery = true)
    MestreEAprendizDTO getMestre(String mestre);

    @Query(value = "select * from JediDTO where midichlorians > 9000", nativeQuery = true)
    MestreEAprendizDTO getNome(String nome);

    @Query(value = "select * from JediDTO where statusEnum = 'JEDI'", nativeQuery = true)
    MestreEAprendizDTO getJedi(StatusEnum statusEnum);
}
