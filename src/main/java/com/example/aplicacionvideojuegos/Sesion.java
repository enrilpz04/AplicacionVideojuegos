package com.example.aplicacionvideojuegos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sesion {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVideojuego(Videojuego videojuego) {
    }
}
