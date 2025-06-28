package com.sel.holamundo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author josesaidolanogarcia
 */
@Entity
public class Mensaje {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String texto;

 public Mensaje() {}

 public Mensaje(String texto) {
     this.texto = texto;
 }

 public Long getId() { return id; }
 public String getTexto() { return texto; }
 public void setTexto(String texto) { this.texto = texto; }
}
