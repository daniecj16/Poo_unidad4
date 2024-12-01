package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Pelicula;

class PeliculaTest {

    @Test
    void testPeliculaCreation() {
        // Arrange
        String titulo = "La Aventura Espacial";
        int duracion = 120;
        String genero = "Ciencia Ficción";
        String estudio = "Estudio Espacial";

        // Act
        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);

        // Assert
        assertEquals(titulo, pelicula.getTitulo());
        assertEquals(duracion, pelicula.getDuracion());
        assertEquals(genero, pelicula.getGenero());
        assertEquals(estudio, pelicula.getEstudio());
    }

    @Test
    void testInvalidDuration() {
        // Arrange
        String titulo = "Corto Mundo";
        int duracion = -50; // Duración negativa debe ser inválida
        String genero = "Drama";
        String estudio = "Estudio Corto";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula(titulo, duracion, genero, estudio);
        });
    }

    @Test
    void testInvalidGenero() {
        // Arrange
        String titulo = "El Viaje al Centro de la Tierra";
        int duracion = 90;
        String genero = ""; // Género vacío debe ser inválido
        String estudio = "Estudio Aventuras";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula(titulo, duracion, genero, estudio);
        });
    }

    @Test
    void testInvalidEstudio() {
        // Arrange
        String titulo = "El Último Heroe";
        int duracion = 100;
        String genero = "Acción";
        String estudio = ""; // Estudio vacío debe ser inválido

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula(titulo, duracion, genero, estudio);
        });
    }
}