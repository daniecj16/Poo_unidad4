package view;

import uni1a.Actor;
import uni1a.Cortometraje;
import uni1a.Documental;
import uni1a.Episodio;
import uni1a.Investigador;
import uni1a.Pelicula;
import uni1a.SerieDeTV;
import uni1a.Temporada;
import uni1a.VideoYouTube;

import java.io.*;
import java.util.*;

@SuppressWarnings("unused")
public class Main {

    private static List<Actor> listaActores = new ArrayList<>();
    private static List<Cortometraje> listaCortometrajes = new ArrayList<>();
    private static List<Documental> listaDocumentales = new ArrayList<>();
    private static List<Pelicula> listaPeliculas = new ArrayList<>();
    private static List<SerieDeTV> listaSeriesDeTV = new ArrayList<>();
    private static List<VideoYouTube> listaVideosYouTube = new ArrayList<>();

    // Cargar actores desde CSV
    public static List<Actor> cargarActores(String rutaArchivo) {
        List<Actor> actores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 3) {
                    String nombre = datos[0];
                    int edad = Integer.parseInt(datos[1]);
                    String nacionalidad = datos[2];
                    actores.add(new Actor(nombre, edad, nacionalidad));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar actores: " + e.getMessage());
        }
        return actores;
    }

    // Guardar actores en CSV
    public static void guardarActores(List<Actor> actores, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Actor actor : actores) {
                writer.write(actor.getNombre() + "," + actor.getEdad() + "," + actor.getNacionalidad());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar actores: " + e.getMessage());
        }
    }

    // Cargar cortometrajes desde CSV
    public static List<Cortometraje> cargarCortometrajes(String rutaArchivo) {
        List<Cortometraje> cortometrajes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    String genero = datos[2];
                    String director = datos[3];
                    cortometrajes.add(new Cortometraje(titulo, duracion, genero, director));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar cortometrajes: " + e.getMessage());
        }
        return cortometrajes;
    }

    // Guardar cortometrajes en CSV
    public static void guardarCortometrajes(List<Cortometraje> cortometrajes, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Cortometraje cortometraje : cortometrajes) {
                writer.write(cortometraje.getTitulo() + "," + cortometraje.getDuracion() + "," + cortometraje.getGenero() + "," + cortometraje.getDirector());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cortometrajes: " + e.getMessage());
        }
    }

    // Cargar documentales desde CSV
    public static List<Documental> cargarDocumentales(String rutaArchivo) {
        List<Documental> documentales = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    String genero = datos[2];
                    String url = datos[3];
                    documentales.add(new Documental(titulo, duracion, genero, url));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar documentales: " + e.getMessage());
        }
        return documentales;
    }

    // Guardar documentales en CSV
    public static void guardarDocumentales(List<Documental> documentales, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Documental documental : documentales) {
                writer.write(documental.getTitulo() + "," + documental.getDuracion() + "," + documental.getGenero() + "," + documental.getUrl());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar documentales: " + e.getMessage());
        }
    }

    // Cargar videos de YouTube desde CSV
    public static List<VideoYouTube> cargarVideosYouTube(String rutaArchivo) {
        List<VideoYouTube> videosYouTube = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    String genero = datos[2];
                    String url = datos[3];
                    videosYouTube.add(new VideoYouTube(titulo, duracion, genero, url));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar videos de YouTube: " + e.getMessage());
        }
        return videosYouTube;
    }

    // Guardar videos de YouTube en CSV
    public static void guardarVideosYouTube(List<VideoYouTube> listaVideosYouTube, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (VideoYouTube video : listaVideosYouTube) {
                writer.write(video.getTitulo() + "," + video.getDuracion() + "," + video.getGenero() + "," + video.getUrl());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar videos de YouTube: " + e.getMessage());
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Cargar y mostrar actores
        listaActores = cargarActores("actores.csv");
        for (Actor actor : listaActores) {
            System.out.println(actor);
        }

        // Agregar un nuevo actor y guardar
        Actor nuevoActor = new Actor("John Doe", 35, "USA");
        listaActores.add(nuevoActor);
        guardarActores(listaActores, "actores.csv");

        // Cargar y mostrar videos de YouTube
        listaVideosYouTube = cargarVideosYouTube("videos.csv");
        for (VideoYouTube video : listaVideosYouTube) {
            video.mostrarDetalles();
        }

        // Agregar un nuevo video de YouTube y guardar
        VideoYouTube nuevoVideo = new VideoYouTube("Nuevo Video", 300, "Documental", "http://example.com");
        listaVideosYouTube.add(nuevoVideo);
        guardarVideosYouTube(listaVideosYouTube, "videos.csv");

        // Verificar que el nuevo video se guardó correctamente cargando los videos nuevamente
        System.out.println("\nVideos después de agregar un nuevo video:");
        listaVideosYouTube = cargarVideosYouTube("videos.csv");
        for (VideoYouTube video : listaVideosYouTube) {
            video.mostrarDetalles();
        }
    }
}
