package com.example.aplicacionvideojuegos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class AplicacionVideojuegosApplication {


    public static void main(String[] args) {
        SpringApplication.run(AplicacionVideojuegosApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("BIENVENIDO A TU APLICACION DE VIDEOJUEGOS");
            System.out.println("Menu:");
            System.out.println("1. Añadir juego");
            System.out.println("2. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    añadirJuego(scanner);
                    break;

                case 2:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 2);
    }

    public static void añadirJuego(Scanner scanner) {

    }
}
