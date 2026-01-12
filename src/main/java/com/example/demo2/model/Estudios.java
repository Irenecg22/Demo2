package com.example.demo2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Movies")
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String institucion;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;


    }


