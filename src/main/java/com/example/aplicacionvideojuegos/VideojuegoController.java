package com.example.aplicacionvideojuegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class VideojuegoController {
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    //select de todos los videojuegos
    @GetMapping("/videojuego/")
    public List<Videojuego> allVideojuegos(){return videojuegoRepository.findAll();}

    //seleccionar videojuego por partida
    @GetMapping("/videojuego/partida/{idPartida}")
    public List<Videojuego> findVideojuegosByPartida(@PathVariable("idPartida") Integer idPartida){
        return videojuegoRepository.findByListaPartidas_IdPartida(idPartida);
    }

    //obtener lista de juegos jugados
    @GetMapping("/videojuego/jugado")
    public List<Videojuego> obtenerVideojuegosJugados() {
        return videojuegoRepository.findByJugado(true);
    }

    //insertar videojuego
    @PostMapping("/videojuego/")
    public ResponseEntity<String> addVideojuego(@RequestBody Videojuego nuevoVideojuego) {
        Videojuego savedVideojuego = videojuegoRepository.save(nuevoVideojuego);
        return new ResponseEntity<>("Videojuego añadido correctamente con ID: " + savedVideojuego.getId(), HttpStatus.CREATED);
    }

    //borrar videojuego por id
    @DeleteMapping("/videojuego/{idVideojuego}")
    public ResponseEntity<String> deleteById(@PathVariable("idVideojuego") Integer idVideojuego){
        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(idVideojuego);
        if(videojuegoOptional.isPresent()){
            videojuegoRepository.deleteById(idVideojuego);
            return new ResponseEntity<>("Videojuego con id " + idVideojuego + " eliminado correctamente", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Videojuego con el id " + idVideojuego + " no encontrdo", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar título del videojuego
    @PatchMapping("/{idVideojuego}/titulo")
    public ResponseEntity<String> updateTituloVideojuego(
            @PathVariable("idVideojuego") Integer idVideojuego,
            @RequestBody Map<String, String> requestBody){

        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(idVideojuego);

        if(videojuegoOptional.isPresent()){
            Videojuego videojuego = videojuegoOptional.get();
            videojuego.setTitulo(requestBody.get("nuevoTitulo"));
            videojuegoRepository.save(videojuego);
            return new ResponseEntity<>("Título del videojuego actualizado correctamente", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Videojuego con id " + idVideojuego + " no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar plataforma del videojuego
    @PatchMapping("/{idVideojuego}/plataforma")
    public ResponseEntity<String> updatePlataformaVideojuego(
            @PathVariable("idVideojuego") Integer idVideojuego,
            @RequestBody Map<String, String> requestBody){

        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(idVideojuego);

        if(videojuegoOptional.isPresent()){
            Videojuego videojuego = videojuegoOptional.get();
            videojuego.setPlataforma(requestBody.get("nuevaPlataforma"));
            videojuegoRepository.save(videojuego);
            return new ResponseEntity<>("Plataforma del videojuego actualizada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Videojuego con id " + idVideojuego + " no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar si es favorito
    @PatchMapping("/{idVideojuego}/favorito")
    public ResponseEntity<String> updateFavoritoVideojuego(
            @PathVariable("idVideojuego") Integer idVideojuego,
            @RequestBody Map<String, Boolean> requestBody){

        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(idVideojuego);

        if(videojuegoOptional.isPresent()){
            Videojuego videojuego = videojuegoOptional.get();
            videojuego.setFavorito(requestBody.get("favorito"));
            videojuegoRepository.save(videojuego);
            return new ResponseEntity<>("Videojuego añadido a favoritos", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Videojuego con id " + idVideojuego + " no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar el género
    @PatchMapping("/{idVideojuego}/genero")
    public ResponseEntity<String> updateGeneroVideojuego(
            @PathVariable("idVideojuego") Integer idVideojuego,
            @RequestBody Map<String, String> requestBody){

        Optional<Videojuego> videojuegoOptional = videojuegoRepository.findById(idVideojuego);

        if(videojuegoOptional.isPresent()){
            Videojuego videojuego = videojuegoOptional.get();
            videojuego.setGenero(requestBody.get("genero"));
            videojuegoRepository.save(videojuego);
            return new ResponseEntity<>("Género actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Videojuego con id " + idVideojuego + " no encontrado", HttpStatus.NOT_FOUND);
        }
    }





}
