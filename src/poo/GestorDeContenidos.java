package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import uni1a.Pelicula;
import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.Cortometraje;
import uni1a.VideoYouTube;
import uni1a.Documental;

public class GestorDeContenidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Listas para almacenar los contenidos creados
        List<Documental> listaDocumentales = new ArrayList<>();
        List<VideoYouTube> listaVideos = new ArrayList<>();
        List<Cortometraje> listaCortometrajes = new ArrayList<>();
        List<SerieDeTV> listaSeries = new ArrayList<>();
        List<Pelicula> listaPeliculas = new ArrayList<>();

        while (continuar) {
            System.out.println("\n¿Qué tipo de contenido deseas agregar?");
            System.out.println("1. Documental");
            System.out.println("2. Video de YouTube");
            System.out.println("3. Cortometraje");
            System.out.println("4. Serie de TV");
            System.out.println("5. Película");
            System.out.println("6. Salir");
            System.out.println("7. Ver contenidos");  // Nueva opción

            int opcion = obtenerEntrada(scanner);

            switch (opcion) {
                case 1:
                    listaDocumentales.add(crearDocumental(scanner));
                    break;
                case 2:
                    listaVideos.add(crearVideoYouTube(scanner));
                    break;
                case 3:
                    listaCortometrajes.add(crearCortometraje(scanner));
                    break;
                case 4:
                    listaSeries.add(crearSerieDeTV(scanner));
                    break;
                case 5:
                    listaPeliculas.add(crearPelicula(scanner));
                    break;
                case 6:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                case 7:
                    verContenidos(listaDocumentales, listaVideos, listaCortometrajes, listaSeries, listaPeliculas);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa un número del 1 al 7.");
                    break;
            }
        }

        scanner.close();
    }

    // Método para obtener la entrada de usuario de forma segura
    private static int obtenerEntrada(Scanner scanner) {
        int opcion = -1;
        while (opcion < 1 || opcion > 7) {
            try {
                System.out.print("Selecciona una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 7) {
                    System.out.println("Por favor, ingresa un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
            }
        }
        return opcion;
    }

    // Método para obtener una entrada de tipo String (para título, género, etc.)
    private static String obtenerEntradaString(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Método para obtener una entrada de tipo int (para duración, etc.)
    private static int obtenerEntradaInt(Scanner scanner, String mensaje) {
        int valor = -1;
        while (valor <= 0) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                if (valor <= 0) {
                    System.out.println("La duración debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes ingresar un número positivo.");
            }
        }
        return valor;
    }

    // Métodos para crear los diferentes tipos de contenido
    private static Documental crearDocumental(Scanner scanner) {
        String titulo = obtenerEntradaString(scanner, "Introduce el título del documental: ");
        int duracion = obtenerEntradaInt(scanner, "Introduce la duración del documental (en minutos): ");
        String genero = obtenerEntradaString(scanner, "Introduce el género del documental: ");
        String url = obtenerEntradaString(scanner, "Introduce la URL del documental: ");
        return new Documental(titulo, duracion, genero, url);
    }

    private static VideoYouTube crearVideoYouTube(Scanner scanner) {
        String titulo = obtenerEntradaString(scanner, "Introduce el título del video de YouTube: ");
        int duracion = obtenerEntradaInt(scanner, "Introduce la duración del video (en segundos): ");
        String genero = obtenerEntradaString(scanner, "Introduce el género del video: ");
        String url = obtenerEntradaString(scanner, "Introduce la URL del video: ");
        return new VideoYouTube(titulo, duracion, genero, url);
 
    }

    private static Cortometraje crearCortometraje(Scanner scanner) {
        // Pedir el título del cortometraje
        String titulo = obtenerEntradaString(scanner, "Introduce el título del cortometraje: ");
        
        // Pedir la duración del cortometraje
        int duracion = obtenerEntradaInt(scanner, "Introduce la duración del cortometraje (en minutos): ");
        
        // Pedir el género del cortometraje
        String genero = obtenerEntradaString(scanner, "Introduce el género del cortometraje: ");
        
        // Pedir el director del cortometraje
        String director = obtenerEntradaString(scanner, "Introduce el director del cortometraje: ");
        
        // Crear y retornar el cortometraje con los datos obtenidos
        return new Cortometraje(titulo, duracion, genero, director);
    }

    private static SerieDeTV crearSerieDeTV(Scanner scanner) {
        String titulo = obtenerEntradaString(scanner, "Introduce el título de la serie de TV: ");
        int anioLanzamiento = obtenerEntradaInt(scanner, "Introduce el año de lanzamiento de la serie: ");
        String genero = obtenerEntradaString(scanner, "Introduce el género de la serie: ");
        // Inicializamos la lista de temporadas como vacía
        List<Temporada> temporadas = new ArrayList<>();
        return new SerieDeTV(titulo, anioLanzamiento, genero, temporadas);
    }

    private static Pelicula crearPelicula(Scanner scanner) {
        String titulo = obtenerEntradaString(scanner, "Introduce el título de la película: ");
        int duracion = obtenerEntradaInt(scanner, "Introduce la duración de la película (en minutos): ");
        String genero = obtenerEntradaString(scanner, "Introduce el género de la película: ");
        String estudio = obtenerEntradaString(scanner, "Introduce el estudio productor de la película: ");
        return new Pelicula(titulo, duracion, genero, estudio);
    }

    // Método para mostrar todos los contenidos
    private static void verContenidos(List<Documental> listaDocumentales, List<VideoYouTube> listaVideos,
                                      List<Cortometraje> listaCortometrajes, List<SerieDeTV> listaSeries,
                                      List<Pelicula> listaPeliculas) {
        System.out.println("\nDocumentales:");
        listaDocumentales.forEach(documental -> System.out.println(documental));
        
        System.out.println("\nVideos de YouTube:");
        listaVideos.forEach(video -> System.out.println(video));
        
        System.out.println("\nCortometrajes:");
        listaCortometrajes.forEach(cortometraje -> System.out.println(cortometraje));
        
        System.out.println("\nSeries de TV:");
        listaSeries.forEach(serie -> System.out.println(serie));
        
        System.out.println("\nPelículas:");
        listaPeliculas.forEach(pelicula -> System.out.println(pelicula));
    }
}
