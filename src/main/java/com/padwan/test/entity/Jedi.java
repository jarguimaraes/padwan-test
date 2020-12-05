package com.padwan.test.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Jedi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private Integer jediMentorId;
  private Integer midichlorians;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private JediStatus status;

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

  public Integer getJediMentorId() {
    return jediMentorId;
  }

  public void setJediMentorId(Integer jediMentor) {
    this.jediMentorId = jediMentor;
  }

  public Integer getMidichlorians() {
    return midichlorians;
  }

  public void setMidichlorians(Integer midichlorians) {
    this.midichlorians = midichlorians;
  }

  public JediStatus getStatus() {
    return status;
  }

  public void setStatus(JediStatus status) {
    this.status = status;
  }

}
