-- Insertar juegos
INSERT INTO videojuego (titulo, genero, descripcion, company, plataforma, favorito, jugado)
VALUES 
    ('The Witcher 3: Wild Hunt', 'RPG', 'Un juego de rol de mundo abierto ambientado en un mundo de fantasía oscuro.', 'CD Projekt Red', 'PC', TRUE, TRUE),
    ('The Legend of Zelda: Breath of the Wild', 'Aventura', 'Un juego de aventuras épico en un mundo abierto.', 'Nintendo', 'Nintendo Switch', TRUE, TRUE),
    ('Grand Theft Auto V', 'Acción', 'Un juego de acción en mundo abierto que sigue las vidas entrelazadas de tres protagonistas.', 'Rockstar Games', 'PlayStation 4', FALSE, TRUE),
    ('Minecraft', 'Sandbox', 'Un juego de construcción y aventuras en un mundo generado proceduralmente.', 'Mojang Studios', 'Xbox One', TRUE, TRUE),
    ('Dark Souls III', 'RPG', 'Un desafiante juego de rol de acción en tercera persona.', 'FromSoftware', 'PC', TRUE, FALSE);

-- Insertar partidas
INSERT INTO sesion (idVideojuego, puntuacion, comentario, horas)
VALUES 
    (1, 85, 'No me ha gustado mucho', 4),
    (1, 80, 'Me ha gustado menos', 3.5),
    (2, 90, 'Buen juego', 4),
    (2, 85, 'Necesitaba rejugarlo', 3.5),
    (3, 75, 'No me gustan los coches', 4),
    (3, 70, 'No voy a jugar mas', 3.5),
    (4, 95, 'Que juegazo', 4),
    (4, 100, 'El mejor juego de la historia', 3.5),
    (5, 80, 'desi?', 4),
    (5, 75, 'definitivamente miguel es mejor que desi jugando a esto', 3.5);

-- Verificar los datos insertados
SELECT * FROM videojuego;
SELECT * FROM sesion;