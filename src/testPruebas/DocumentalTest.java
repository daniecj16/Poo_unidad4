package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Documental;

class DocumentalTest {

    @Test
    void testDocumentalCreation() {
        // Arrange
        String titulo = "El Viaje al Espacio";
        int duracion = 90;
        String genero = "Ciencia";
        String url = "http://espacio.com";
        
        // Act
        Documental documental = new Documental(titulo, duracion, genero, url);
        
        // Assert
        assertEquals(titulo, documental.getTitulo());
        assertEquals(duracion, documental.getDuracion());
        assertEquals(genero, documental.getGenero());
        assertEquals(url, documental.getUrl());
    }

    @Test
    void testInvalidDuration() {
        // Arrange
        String titulo = "Corto Mundo";
        int duracion = -30; // Duración negativa debe ser inválida
        String genero = "Historia";
        String url = "http://corto.com";
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Documental(titulo, duracion, genero, url);
        });
    }
}
