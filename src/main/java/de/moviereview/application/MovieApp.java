package de.moviereview.application;

import de.moviereview.infrastructure.TMDbService;

import java.util.Scanner;

public class MovieApp {

    public static void main(String[] args) {
        TMDbService tmdbService = new TMDbService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zur Filmverwaltung!");

        boolean running = true;
        while (running) {
            System.out.println("\nWas möchten Sie tun?");
            System.out.println("1. Beliebte Filme anzeigen (online)");
            System.out.println("2. Film-Details anzeigen (online, nach TMDb-ID)");
            System.out.println("3. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Verbrauche den restlichen Teil der Eingabe

            switch (choice) {
                case 1:
                    // Beliebte Filme anzeigen
                    String popularMovies = tmdbService.fetchPopularMovies();
                    if (popularMovies != null) {
                        System.out.println("Beliebte Filme von TMDb:");
                        System.out.println(popularMovies); // Zeigt die JSON-Antwort direkt an (kann angepasst werden)
                    } else {
                        System.out.println("Keine Filme gefunden.");
                    }
                    break;

                case 2:
                    // Film-Details anzeigen (nach TMDb-ID)
                    System.out.print("Geben Sie die TMDb-ID des Films ein: ");
                    Long tmdbId = scanner.nextLong();
                    String movieDetails = tmdbService.fetchMovieDetails(tmdbId);
                    if (movieDetails != null) {
                        System.out.println("Film-Details von TMDb:");
                        System.out.println(movieDetails); // Zeigt die JSON-Antwort direkt an (kann angepasst werden)
                    } else {
                        System.out.println("Film nicht gefunden.");
                    }
                    break;

                case 3:
                    // Programm beenden
                    running = false;
                    System.out.println("Programm wird beendet. Auf Wiedersehen!");
                    break;

                default:
                    System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
                    break;
            }
        }
    }
}
