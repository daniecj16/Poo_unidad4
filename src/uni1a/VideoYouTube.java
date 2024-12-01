package uni1a;

import java.io.FileWriter;
import java.io.IOException;

public class VideoYouTube {
    private String titulo;  // Título del video
    private int duracion;  // Duración del video en segundos
    private String genero;  // Género del video
    private String url;  // URL del video en YouTube

    // Constructor para inicializar un video de YouTube con su título, duración, género y URL
    public VideoYouTube(String titulo, int duracion, String genero, String url) {
        if (titulo == null || titulo.isEmpty()) 
            throw new IllegalArgumentException("El título no puede estar vacío.");
        
        if (duracion <= 0) 
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        
        if (url == null || url.isEmpty()) 
            throw new IllegalArgumentException("La URL no puede estar vacía.");
        
        // Validación de la URL (debe empezar con http:// o https://)
        if (!url.matches("^(http|https)://.*")) {
            throw new IllegalArgumentException("La URL debe comenzar con http:// o https://");
        }
        
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }

    // Método para mostrar los detalles del video
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " segundos");
        System.out.println("Género: " + genero);
        System.out.println("URL: " + url);
    }

    // Método para guardar los detalles del video en un archivo CSV
    public void guardarEnCSV(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            StringBuilder sb = new StringBuilder();

            // Agregar título, duración, género y URL al CSV, rodeando los valores con comillas dobles para manejar comas
            sb.append("\"").append(titulo).append("\",");
            sb.append(duracion).append(",");
            sb.append("\"").append(genero).append("\",");
            sb.append("\"").append(url).append("\"\n");

            // Escribir la cadena en el archivo
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error al guardar el video en el archivo CSV: " + e.getMessage());
        }
    }

    // Método toString() para representar el video en formato legible
    @Override
    public String toString() {
        return "VideoYouTube{" +
               "titulo='" + titulo + '\'' +
               ", duracion=" + duracion +
               ", genero='" + genero + '\'' +
               ", url='" + url + '\'' +
               '}';
    }

    // Métodos getter
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
}
