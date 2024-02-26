package com.example.aplicacionvideojuegos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SesionController {

    @Autowired
    private SesionRepository sesionRepository;

    //select de todas las sesiones
    @GetMapping("/sesion/")
    public List<Sesion> allSesions(){return sesionRepository.findAll();}

    //Seleccionar las partidas de un videojuego concreto
    @GetMapping("/sesion/videojuego/{idVideojuego}")
    public List<Sesion> findSesionByVideojuego(@PathVariable("idVideojuego") Integer idVideojuego){
        return sesionRepository.findPartidasByIdVideojuego(idVideojuego);
    }

    //insertar sesion
    @PostMapping("/sesion/")
    public ResponseEntity<String> addSesion(@RequestBody Sesion nuevaSesion) {
        Sesion savedSesion = sesionRepository.save(nuevaSesion);
        return new ResponseEntity<>("Sesion añadida correctamente con ID: " + savedSesion.getIdSesion(), HttpStatus.CREATED);
    }


}
