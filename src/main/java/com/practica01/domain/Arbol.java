package com.practica01.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="arbol")
public class Arbol implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idArbol")
    private Long idArbol;
  
    private String nombreArbol;
    private double alturaArbol;
    private String durezaMadera;
    private String tipoFlor;
    private String rutaImagen;
//    private boolean activo;
}