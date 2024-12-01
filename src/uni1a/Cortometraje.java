package uni1a;

// Clase que representa un cortometraje, con título, duración, género y director
public class Cortometraje {
    private String titulo;  // Título del cortometraje
    private int duracion;   // Duración del cortometraje en segundos
    private String genero;  // Género del cortometraje (ej. drama, comedia)
    private String director; // Director del cortometraje
    
    // Constructor para inicializar un cortometraje con título, duración, género y director
    public Cortometraje(final String titulo, final int duracion, final String genero, final String director) {
        this.titulo = titulo;
        setDuracion(duracion);  // Usamos el setter para validar la duración
        this.genero = genero;
        this.director = director;
    }

    // Método setter para validar la duración
    public void setDuracion(int duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa.");
        }
        this.duracion = duracion;
    }

    // Método para mostrar los detalles del cortometraje
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Duración: " + duracion + " segundos");
        System.out.println("Género: " + genero);
        System.out.println("Director: " + director);
    }

    // Métodos getter para acceder a los valores de los atributos
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    // Método toString para representar los atributos del cortometraje en formato CSV
    @Override
    public String toString() {
        return titulo + "," + duracion + "," + genero + "," + director;  // Devolver los valores en formato CSV
    }

	public char[] toCSV() {
		// TODO Auto-generated method stub
		return null;
	}
}
