package uni1a;

import java.util.ArrayList;
import java.util.List;

// Clase que representa una película
public class Pelicula {
    private String titulo;           // Título de la película
    private int duracion;            // Duración de la película en segundos
    private String genero;           // Género de la película
    private String estudio;          // Estudio que produjo la película
    private List<Actor> actores;     // Lista de actores que participan en la película

    // Constructor para inicializar la película con título, duración, género, estudio y lista de actores
    public Pelicula(final String titulo, final int duracion, final String genero, final String estudio) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }
        if (estudio == null || estudio.isEmpty()) {
            throw new IllegalArgumentException("El estudio no puede estar vacío.");
        }

        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.estudio = estudio;
        this.actores = new ArrayList<>();  // Inicializamos la lista de actores
    }

    // Método para agregar un actor a la lista de actores de la película
    public void agregarActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException("El actor no puede ser nulo.");
        }
        this.actores.add(actor);
    }

    // Método para mostrar los detalles de la película y los actores
    public void mostrarDetalles() {
        System.out.println("Película: " + titulo + " | Duración: " + duracion + " segundos | Género: " + genero + " | Estudio: " + estudio);
        System.out.println("Actores:");
        for (Actor actor : actores) {
            System.out.println("- " + actor.getNombre() + " (Edad: " + actor.getEdad() + ", Nacionalidad: " + actor.getNacionalidad() + ")");
        }
    }

    // Métodos getter para acceder a los atributos de la película
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public List<Actor> getActores() {
        return actores;
    }

    // Método toString() para representar la película en formato CSV
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append(",").append(duracion).append(",").append(genero).append(",").append(estudio);

        // Agregar los actores en el formato adecuado
        if (!actores.isEmpty()) {
            sb.append(",");
            for (Actor actor : actores) {
                sb.append(actor.getNombre()).append(";");
            }
            // Eliminar la última coma
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

