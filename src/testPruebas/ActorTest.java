package testPruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uni1a.Actor;

class ActorTest {

    @Test
    void testActorCreation() {
        // Arrange
        String nombre = "Tom Hanks";
        int edad = 65;
        String nacionalidad = "Estadounidense";

        // Act
        Actor actor = new Actor(nombre, edad, nacionalidad);

        // Assert
        assertEquals(nombre, actor.getNombre());
        assertEquals(edad, actor.getEdad());
        assertEquals(nacionalidad, actor.getNacionalidad());
    }

    @Test
    void testInvalidAge() {
        // Arrange
        String nombre = "Robert Downey Jr.";
        int edad = -5; // Edad negativa no es válida
        String nacionalidad = "Estadounidense";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Actor(nombre, edad, nacionalidad);
        });
    }

    @Test
    void testSetName() {
        // Arrange
        String nombre = "Chris Hemsworth";
        int edad = 38;
        String nacionalidad = "Australiano";

        // Act
        Actor actor = new Actor(nombre, edad, nacionalidad);
        actor.setNombre("Chris Evans");

        // Assert
        assertEquals("Chris Evans", actor.getNombre());
    }

    @Test
    void testToString() {
        // Arrange
        String nombre = "Natalie Portman";
        int edad = 39;
        String nacionalidad = "Estadounidense";

        // Act
        Actor actor = new Actor(nombre, edad, nacionalidad);

        // Assert
        assertEquals("Natalie Portman,39,Estadounidense", actor.toString());
    }
}