package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Episodio;

class EpisodioTest {

    @Test
    void testEpisodioCreation() {
        // Arrange
        String titulo = "Episodio 1";
        int duracion = 40;
        int temporada = 1;

        // Act
        Episodio episodio = new Episodio(titulo, duracion, temporada);

        // Assert
        assertEquals(titulo, episodio.getTitulo());
        assertEquals(duracion, episodio.getDuracion());
        assertEquals(temporada, episodio.getTemporada());
    }

    @Test
    void testInvalidDuration() {
        // Arrange
        String titulo = "Episodio 2";
        int duracion = -10; // Duración negativa no es válida
        int temporada = 2;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Episodio(titulo, duracion, temporada);
        });
    }

    @Test
    void testToString() {
        // Arrange
        String titulo = "Episodio Final";
        int duracion = 60;
        int temporada = 3;

        // Act
        Episodio episodio = new Episodio(titulo, duracion, temporada);

        // Assert
        assertEquals("Episodio Final,60,3", episodio.toString());
    }
}
