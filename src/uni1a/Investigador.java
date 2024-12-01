package uni1a;

public class Investigador {
    private String nombre;           // Nombre del investigador
    private String especialidad;     // Especialidad del investigador

    // Constructor para inicializar el investigador con nombre y especialidad
    public Investigador(String nombre, String especialidad) {
        if (especialidad == null || especialidad.isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // Método toString para representar al investigador en formato de texto
    @Override
    public String toString() {
        return nombre + "," + especialidad;  
    }
}

