package uni1a;

// Clase que representa a un actor, incluyendo su nombre, edad y nacionalidad
public class Actor {
    private String nombre; // Nombre del actor
    private int edad; // Edad del actor
    private String nacionalidad; // Nacionalidad del actor

    // Constructor para inicializar un actor con su nombre, edad y nacionalidad
    public Actor(final String nombre, final int edad, final String nacionalidad) {
        this.nombre = nombre;
        setEdad(edad); // Llamamos al setter para validar la edad
        this.nacionalidad = nacionalidad;
    }

    // Método getter para obtener el nombre del actor
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del actor
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener la edad del actor
    public int getEdad() {
        return edad;
    }

    // Método setter para establecer la edad del actor (con validación)
    public void setEdad(final int edad) {
        if (edad >= 0) {
            this.edad = edad; // Validamos que la edad no sea negativa
        } else {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
    }

    // Método getter para obtener la nacionalidad del actor
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Método setter para establecer la nacionalidad del actor
    public void setNacionalidad(final String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Método toString para representar al actor en formato CSV (útil para guardar en archivos CSV)
    @Override
    public String toString() {
        return nombre + "," + edad + "," + nacionalidad;
    }
}
