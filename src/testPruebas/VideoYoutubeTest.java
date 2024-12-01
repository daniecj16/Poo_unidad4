package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.VideoYouTube;

class VideoYouTubeTest {

    @Test
    void testVideoYouTubeCreation() {
        // Arrange
        String titulo = "Video Educativo";
        int duracion = 120;
        String genero = "Educación";
        String url = "http://educativo.com";
        
        // Act
        VideoYouTube video = new VideoYouTube(titulo, duracion, genero, url);
        
        // Assert
        assertEquals(titulo, video.getTitulo());
        assertEquals(duracion, video.getDuracion());
        assertEquals(genero, video.getGenero());
        assertEquals(url, video.getUrl());
    }

    @Test
    void testInvalidDuration() {
        // Arrange
        String titulo = "Video Corto";
        int duracion = -10; // Duración negativa debe ser inválida
        String genero = "Corto";
        String url = "http://corto.com";
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new VideoYouTube(titulo, duracion, genero, url);
        });
    }

    @Test
    void testInvalidUrl() {
        // Arrange
        String titulo = "Video Sin URL";
        int duracion = 60;
        String genero = "Sin URL";
        String url = ""; // URL vacía debe ser inválida
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new VideoYouTube(titulo, duracion, genero, url);
        });
    }

    @Test
    void testInvalidUrlFormat() {
        // Arrange
        String titulo = "Video con URL incorrecta";
        int duracion = 120;
        String genero = "Educación";
        String url = "educativo.com"; // URL sin http:// o https://
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new VideoYouTube(titulo, duracion, genero, url);
        });
    }
}
