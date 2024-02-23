package com.example.aplicacionvideojuegos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {

    List<Videojuego> findByListaPartidas_IdPartida(Integer idPartida);

    List<Videojuego> findByJugado(boolean jugado);
}
