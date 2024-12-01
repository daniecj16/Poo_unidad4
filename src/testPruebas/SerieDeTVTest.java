package testPruebas;

import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.Episodio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SerieDeTVTest {

    @Test
    void testSerieDeTVCreation() {
        // Crear episodios
        Episodio episodio1 = new Episodio("Episodio 1", 45, 1);
        Episodio episodio2 = new Episodio("Episodio 2", 50, 1);

        // Crear temporadas
        Temporada temporada1 = new Temporada(1, Arrays.asList(episodio1, episodio2));

        // Crear serie de TV con un año de lanzamiento dentro del rango válido (1900 - 2024)
        SerieDeTV serie = new SerieDeTV("Mi Serie Favorita", 2022, "Drama", Arrays.asList(temporada1));

        // Asegurarse de que el título y el año sean correctos
        assertEquals("Mi Serie Favorita", serie.getTitulo());
        assertEquals(2022, serie.getAnioLanzamiento());
    }

    // Otro test para probar el manejo de excepciones si el año es inválido
    @Test
    void testInvalidYear() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new SerieDeTV("Serie Invalida", 1899, "Drama", Arrays.asList());
        });
    }
}
