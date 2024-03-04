package com.example.aplicacionvideojuegos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion,Integer> {

    List<Sesion> findAll();

    @Query("SELECT c FROM Sesion c ORDER BY c.puntuacion DESC")
    List<Sesion> findPartidasOrderByPuntuacion(@Param("puntuacion") Integer puntuacion);

    @Query("SELECT c FROM Sesion c ORDER BY c.tiempoJuego DESC")
    List<Sesion> findPartidasOrderByTiempoJuego(@Param("tiempoJuego") Float tiempoJuego);


}
