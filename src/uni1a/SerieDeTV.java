package uni1a;

import java.util.List;

public class SerieDeTV {
    private String titulo;             // Título de la serie
    private int anioLanzamiento;       // Año de lanzamiento de la serie
    private String genero;             // Género de la serie
    private List<Temporada> temporadas; // Lista de temporadas de la serie

    // Constructor para inicializar los atributos de la serie
    public SerieDeTV(final String titulo, final int anioLanzamiento, final String genero, final List<Temporada> temporadas) {
        if (anioLanzamiento < 1900 || anioLanzamiento > 2024) {
            throw new IllegalArgumentException("El año de lanzamiento no es válido.");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }

        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
        this.temporadas = temporadas;
    }

    // Métodos getter para acceder a los atributos de la serie
    public String getTitulo() {
        return titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    // Método toString() para representar la serie como texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(titulo).append("\n")
          .append("Año de lanzamiento: ").append(anioLanzamiento).append("\n")
          .append("Género: ").append(genero).append("\n")
          .append("Temporadas:\n");
        for (Temporada temporada : temporadas) {
            sb.append("  Temporada ").append(temporada.getNumeroTemporada()).append("\n");
            for (Episodio episodio : temporada.getEpisodio()) {
                sb.append("    Episodio: ").append(episodio.getTitulo())
                  .append(" (Duración: ").append(episodio.getDuracion()).append(" minutos)\n");
            }
        }
        return sb.toString();
    }
}
