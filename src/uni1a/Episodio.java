package uni1a;

public class Episodio {
    private String titulo;              // Título del episodio
    private int duracionEnMinutos;      // Duración del episodio en minutos
    private int temporada;              // Número de temporada en la que se encuentra el episodio

    // Constructor con título, duración y temporada
    public Episodio(final String titulo, final int duracionEnMinutos, final int temporada) {
        if (duracionEnMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva.");
        }
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.temporada = temporada;
    }

    // Métodos getter
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracionEnMinutos;
    }

    public int getTemporada() {
        return temporada;
    }

    // Método toString para representar el episodio como texto
    @Override
    public String toString() {
        return titulo + "," + duracionEnMinutos + "," + temporada;  // Formato esperado por la prueba
    }
}
