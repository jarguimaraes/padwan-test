package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.dto.MestreEAprendizDTO;
import com.padwan.test.dto.RelacionamentoJediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.RelacionamentoJedi;
import com.padwan.test.enums.StatusEnum;
import com.padwan.test.repository.JediRepository;
import com.padwan.test.repository.RelacionamentoJediRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    @Autowired
    private RelacionamentoJediRepository relacionamentoJediRepository;

    public List<JediDTO> findAll() {
        List<Jedi> jedis = repository.findAll();
        List<JediDTO> listJedis = new ArrayList<>();
        jedis.forEach(it -> listJedis.add(new JediDTO(it)));
        return listJedis;
    }

    public JediDTO incluir(JediDTO jediDTO) {
        Jedi jedi = new Jedi();
//        jedi.setId(jediDTO.getId());
        jedi.setNome(jediDTO.getNome());
        jedi.setStatusEnum(jediDTO.getStatusEnum());
        jedi.setMidichlorians(jediDTO.getMidichlorians());
        JediDTO jediDTO1 = new JediDTO(repository.save(jedi));
        if (jediDTO.getIdMentor() != null && jediDTO.getIdMentor() != 0){
            RelacionamentoJedi relacionamentoJedi = new RelacionamentoJedi();
            relacionamentoJedi.setIdMentor(jediDTO.getIdMentor());
            relacionamentoJedi.setIdAprendiz(jediDTO1.getId());
            RelacionamentoJediDTO relacionamentoJediDTO = new RelacionamentoJediDTO(relacionamentoJediRepository.save(relacionamentoJedi));
            jediDTO1.setIdMentor(relacionamentoJediDTO.getIdMentor());
        }
        return jediDTO1;
    }

    public List<MestreEAprendizDTO> mestreEAprendiz() {
        List<Jedi> jedis = consultarTodosJedis();
        List<MestreEAprendizDTO> mestreEAprendizDTOS = consultarMestreEAprendiz(jedis);

        return mestreEAprendizDTOS;

    }

    public List<Jedi> consultarTodosJedis(){
        Connection c = null;
        Statement stmt = null;
        List<Jedi> jedis = new ArrayList<>();
        try {
            c = conectar(c);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jedi;");
            while (rs.next()) {
                Jedi jedi = new Jedi();
                jedi.setId(rs.getInt("id"));
                jedi.setNome(rs.getString("nome"));
                jedi.setMidichlorians(rs.getInt("midichlorians"));
                jedi.setStatusEnum(consultarStatus(rs.getInt("status_enum")));
                jedis.add(jedi);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return jedis;
    }

    public StatusEnum consultarStatus(Integer status){
        switch (status){
            case 0:
                return StatusEnum.PADAWAN;
            case 1:
                return StatusEnum.JEDI;
            default:
                return StatusEnum.MESTRE_JEDI;
        }
    }

    public List<MestreEAprendizDTO> consultarMestreEAprendiz(List<Jedi> jedis){
        Connection c = null;
        Statement stmt = null;
        List<MestreEAprendizDTO> mestreEAprendizDTOS = new ArrayList<>();
        try {
            for (Jedi jedi : jedis){
                c = conectar(c);
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM relacionamento_jedi WHERE id_mentor = " + jedi.getId());
                List<RelacionamentoJedi> relacionamentoJedis = new ArrayList<>();
                while (rs.next()) {
                    RelacionamentoJedi relacionamentoJedi = new RelacionamentoJedi();
                    relacionamentoJedi.setId(rs.getInt("id"));
                    relacionamentoJedi.setIdMentor(rs.getInt("id_mentor"));
                    relacionamentoJedi.setIdAprendiz(rs.getInt("id_aprendiz"));
                    relacionamentoJedis.add(relacionamentoJedi);
                }
                rs.close();
                stmt.close();
                c.close();
                if (relacionamentoJedis != null && relacionamentoJedis.size() > 0){
                    mestreEAprendizDTOS.add(processarMestreEAprendiz(jedis, relacionamentoJedis, jedi));
                }
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return mestreEAprendizDTOS;
    }

    public MestreEAprendizDTO processarMestreEAprendiz(List<Jedi> jedis, List<RelacionamentoJedi> relacionamentoJedis, Jedi mentor){
        List<Jedi> aprendizes = new ArrayList<>();
        for(RelacionamentoJedi relacionamentoJedi : relacionamentoJedis){
            for (Jedi jedi : jedis){
                if (jedi.getId() == relacionamentoJedi.getIdAprendiz()){
                    aprendizes.add(jedi);
                }
            }
        }
        MestreEAprendizDTO mestreEAprendizDTO = new MestreEAprendizDTO(mentor, aprendizes);
        return mestreEAprendizDTO;
    }

    public List<JediDTO> consultarMidichlorians(){
        Connection c = null;
        Statement stmt = null;
        List<JediDTO> jedis = new ArrayList<>();
        try {
            c = conectar(c);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM jedi WHERE midichlorians > 9000 ");
            while (rs.next()) {
                JediDTO jedi = new JediDTO();
                jedi.setId(rs.getInt("id"));
                jedi.setNome(rs.getString("nome"));
                jedi.setMidichlorians(rs.getInt("midichlorians"));
                jedi.setStatusEnum(consultarStatus(rs.getInt("status_enum")));
                jedis.add(jedi);
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return jedis;
    }

    public JSONObject consultarPorCategoria(){
        Connection c = null;
        Statement stmt = null;
        JSONObject json = new JSONObject();
        try {
            c = conectar(c);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as qt, status_enum FROM jedi GROUP BY status_enum");
            List<List<String>> categorias = new ArrayList<>();
            while (rs.next()) {
                categorias.add(montarString(rs.getInt("status_enum"),rs.getInt("qt")));
                System.out.println("Qt: " + rs.getInt("qt")+" status_enum: "+ rs.getInt("status_enum"));
            }
            json.put("Itens", categorias);
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return json;
    }

    public List<String> montarString(Integer statusEnum, Integer quantidade){

        List<String> categoria = new ArrayList<>();
        categoria.add("Categoria: " + consultarStatus(statusEnum));
        categoria.add("Quantidade: " + quantidade);
        return categoria;

    }

    public Connection conectar(Connection c) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/padawan",
                            "postgres", "123456");
            c.setAutoCommit(false);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

}
