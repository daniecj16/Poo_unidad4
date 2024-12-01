package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Investigador;

class InvestigadorTest {

    @Test
    void testInvestigadorCreation() {
        // Arrange
        String nombre = "Dr. Smith";
        String especialidad = "Astrofísica";

        // Act
        Investigador investigador = new Investigador(nombre, especialidad);

        // Assert
        assertEquals(nombre, investigador.getNombre());
        assertEquals(especialidad, investigador.getEspecialidad());
    }

    @Test
    void testInvalidEspecialidad() {
        // Arrange
        String nombre = "Dr. Johnson";
        String especialidad = ""; // Especialidad vacía no es válida

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Investigador(nombre, especialidad);
        });
    }

    @Test
    void testToString() {
        // Arrange
        String nombre = "Dr. White";
        String especialidad = "Biología Molecular";

        // Act
        Investigador investigador = new Investigador(nombre, especialidad);

        // Assert
        assertEquals("Dr. White,Biología Molecular", investigador.toString());
    }
}


