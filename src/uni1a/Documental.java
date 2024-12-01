package uni1a;

import java.util.List;
import java.util.ArrayList;

// Clase que representa un documental, incluyendo título, duración, género, URL y la lista de investigadores
public class Documental {
    private String titulo;  // Título del documental
    private int duracion;   // Duración del documental en minutos
    private String genero;  // Género del documental (ej. naturaleza, historia, ciencia)
    private String url;     // URL donde se puede acceder al documental
    private List<Investigador> investigador; // Lista de investigador que participaron en el documental

    // Constructor para inicializar un documental con título, duración, género y URL
    public Documental(final String titulo, final int duracion, final String genero, final String url) {
        this.titulo = titulo;
        setDuracion(duracion); // Usamos el setter para validar la duración
        this.genero = genero;
        this.url = url;
        this.investigador = new ArrayList<>(); // Inicializamos la lista de investigador
    }

    // Método setter para la duración con validación
    public void setDuracion(final int duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa.");
        }
        this.duracion = duracion;
    }

    // Método para agregar un investigador a la lista de investigadores del documental
    public void agregarInvestigador(final Investigador investigador) {
        this.investigador.add(investigador);  // Añade el investigador a la lista
    }

    // Métodos getter para obtener los valores de los atributos del documental
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getUrl() {
        return url;
    }

    public List<Investigador> getInvestigador() {
        return investigador;
    }

    // Método para mostrar los detalles del documental en consola
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Género: " + genero);
        System.out.println("URL: " + url);
        System.out.println("Investigadores:");
        if (investigador.isEmpty()) {
            System.out.println("No hay investigadores registrados.");
        } else {
            for (Investigador investigador : investigador) {
                System.out.println("- " + investigador.getNombre());
            }
        }
    }

    // Método toString para representar los atributos del documental en formato CSV
    @Override
    public String toString() {
        // Si la lista de investigadores es extensa, podrías formatearla mejor o agregar un límite
        StringBuilder investigadorString = new StringBuilder();
        for (Investigador investigador : investigador) {
            investigadorString.append(investigador.getNombre()).append(";");
        }

        // Eliminar el último separador ";" si la lista no está vacía
        if (investigadorString.length() > 0) {
            investigadorString.setLength(investigadorString.length() - 1);
        }

        return titulo + "," + duracion + "," + genero + "," + url + "," + investigadorString;
    }
}

