package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private int numeroTemporada;  // Número de la temporada
    private List<Episodio> episodio;  // Lista de episodios en la temporada

    // Constructor para inicializar la temporada con su número y lista de episodios
    public Temporada(final int numeroTemporada, final List<Episodio> episodio) {
        if (numeroTemporada <= 0) {
            throw new IllegalArgumentException("El número de temporada debe ser mayor que cero.");
        }
        this.numeroTemporada = numeroTemporada;
        this.episodio = episodio != null ? episodio : new ArrayList<>(); // Evitar NPE si episodio es null
    }

    // Método getter para obtener el número de temporada
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    // Método getter para obtener la lista de episodios de la temporada
    public List<Episodio> getEpisodio() {
        return episodio;
    }

    // Método toString() para representar la temporada de forma legible
    @Override
    public String toString() {
        if (episodio.isEmpty()) {
            return "Temporada " + numeroTemporada + ": No hay episodios disponibles.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Temporada ").append(numeroTemporada).append(": ");
        
        for (Episodio episodio : episodio) {
            sb.append(episodio.getTitulo())
              .append(" (").append(episodio.getDuracion()).append(" min), ");
        }

        sb.setLength(sb.length() - 2); 
        return sb.toString();
    }
}
