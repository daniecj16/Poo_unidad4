package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Cortometraje;

class CortometrajeTest {

    @Test
    void testCortometrajeCreation() {
        // Arrange
        String titulo = "Corto Ciencia";
        int duracion = 15;
        String genero = "Ciencia";
        String director = "Juan Pérez";
        
        // Act
        Cortometraje cortometraje = new Cortometraje(titulo, duracion, genero, director);
        
        // Assert
        assertEquals(titulo, cortometraje.getTitulo());
        assertEquals(duracion, cortometraje.getDuracion());
        assertEquals(genero, cortometraje.getGenero());
        assertEquals(director, cortometraje.getDirector());
    }

    @Test
    void testInvalidDuration() {
        // Arrange
        String titulo = "Corto Drama";
        int duracion = -5; // Duración negativa debe ser inválida
        String genero = "Drama";
        String director = "María López";
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Cortometraje(titulo, duracion, genero, director);
        });
    }
}