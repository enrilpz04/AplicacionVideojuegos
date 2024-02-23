package com.example.aplicacionvideojuegos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String genero;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String companya;
    @Column(nullable = false)
    private String plataforma;
    @Column(nullable = false)
    private Boolean favorito;
    @Column(nullable = false)
    private Boolean jugado;


    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sesion> sesiones = new ArrayList<>();

    public Videojuego() {
    }

    public Videojuego(String titulo, String genero, String descripcion, String companya, String plataforma, Boolean favorito, Boolean jugado) {
        this.titulo = titulo;
        this.genero = genero;
        this.descripcion = descripcion;
        this.companya = companya;
        this.plataforma = plataforma;
        this.favorito = favorito;
        this.jugado = jugado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && titulo.length() <= 45) {
            this.titulo = titulo;
        } else {
            // Puedes lanzar una excepción, imprimir un mensaje de error, o tomar alguna otra acción
            throw new IllegalArgumentException("El título debe tener menos de 45 caracteres.");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero != null && genero.length() <= 45) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("El género debe tener menos de 45 caracteres.");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() <= 256) {
            this.descripcion = descripcion;
        } else {
            throw new IllegalArgumentException("La descripción debe tener menos de 256 caracteres.");
        }
    }

    public String getCompanya() {
        return companya;
    }

    public void setCompanya(String companya) {
        if (companya != null && companya.length() <= 45) {
            this.companya = companya;
        } else {
            throw new IllegalArgumentException("La compañía debe tener menos de 45 caracteres.");
        }
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if (plataforma != null && plataforma.length() <= 50) {
            this.plataforma = plataforma;
        } else {
            throw new IllegalArgumentException("El género debe tener menos de 50 caracteres.");
        }
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getJugado() {
        return jugado;
    }

    public void setJugado(Boolean jugado) {
        this.jugado = jugado;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }

    public void agregarSesion(Sesion sesion) {
        sesiones.add(sesion);
        sesion.setVideojuego(this);
    }

    public void eliminarSesion(Sesion sesion) {
        sesiones.remove(sesion);
        sesion.setVideojuego(null);
    }
}
