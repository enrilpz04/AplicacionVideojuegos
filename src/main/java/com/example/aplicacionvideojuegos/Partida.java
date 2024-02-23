package com.example.aplicacionvideojuegos;


import jakarta.persistence.*;


@Entity
@Table(name="Partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartida;

    @Column(nullable = false)
    private Integer puntuacion;

    @Column(nullable = false)
    private String comentario;

}
