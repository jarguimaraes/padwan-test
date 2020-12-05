package com.padwan.test.dto;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.JediStatus;

public class JediDTO {

  private Integer id;
  private String nome;
  private JediStatus status;
  private Integer jediMentorId;
  private Integer midichlorians;

  public JediDTO() {
  }

  public JediDTO(Jedi jedi) {
    this.id = jedi.getId();
    this.nome = jedi.getNome();
    this.status = jedi.getStatus();
    this.jediMentorId = jedi.getJediMentorId();
    this.midichlorians = jedi.getMidichlorians();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public JediStatus getStatus() {
    return status;
  }

  public void setStatus(JediStatus status) {
    this.status = status;
  }

  public Integer getJediMentorId() {
    return jediMentorId;
  }

  public void setJediMentorId(Integer jediMentorId) {
    this.jediMentorId = jediMentorId;
  }

  public Integer getMidichlorians() {
    return midichlorians;
  }

  public void setMidichlorians(Integer midichlorians) {
    this.midichlorians = midichlorians;
  }

}
