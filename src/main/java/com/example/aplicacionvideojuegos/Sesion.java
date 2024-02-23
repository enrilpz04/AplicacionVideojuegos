package com.example.aplicacionvideojuegos;

import jakarta.persistence.*;

@Entity
@Table(name="Sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSesion;

    @Column(nullable = false)
    private Integer puntuacion;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private Float tiempoJuego;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idPartida) {
        this.idSesion = idPartida;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Float getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(Float tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
}
