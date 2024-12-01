package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Temporada;
import uni1a.Episodio;

import java.util.ArrayList;
import java.util.List;

class TemporadaTest {

    @Test
    void testTemporadaCreation() {
        // Arrange
        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("Episodio 1", 45, 1));
        episodios.add(new Episodio("Episodio 2", 50, 1));
        int numeroTemporada = 1;

        // Act
        Temporada temporada = new Temporada(numeroTemporada, episodios);

        // Assert
        assertEquals(numeroTemporada, temporada.getNumeroTemporada());
        assertEquals(2, temporada.getEpisodio().size());
    }

    @Test
    void testInvalidNumeroTemporada() {
        // Arrange
        List<Episodio> episodios = new ArrayList<>();
        int numeroTemporada = -1; // Número de temporada inválido

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Temporada(numeroTemporada, episodios);
        });
    }

    @Test
    void testToString() {
        // Arrange
        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("Episodio 1", 45, 1));
        int numeroTemporada = 1;

        // Act
        Temporada temporada = new Temporada(numeroTemporada, episodios);
        // Assert
        assertEquals("Temporada 1: Episodio 1 (45 min)", temporada.toString());
    }
}