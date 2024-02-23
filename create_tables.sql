CREATE TABLE Videojuego (
    idVideojuego INT PRIMARY KEY,
    titulo VARCHAR(45) NOT NULL,
    genero VARCHAR(45) NOT NULL,
	descripcion VARCHAR(256) NOT NULL,
    company VARCHAR(45) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
	favorito BOOLEAN NOT NULL,
    jugado BOOLEAN NOT NULL
);

CREATE TABLE Sesion (
    idSesion INT PRIMARY KEY,
    puntuacion INT,
    comentario VARCHAR(256),
    horas FLOAT,
    idVideojuego INT REFERENCES Videojuego(idVideojuego)
);