package de.moviereview.infrastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMDbService {

    private final String apiKey = "0e14c15b7f0b81396f35e3f9c93f3f8c"; // Dein API Key hier
    private final String baseUrl = "https://api.themoviedb.org/3";

    // Diese Methode holt die Details eines Films anhand der TMDb-ID und gibt die Informationen als String zurück
    public String fetchMovieDetails(Long movieId) {
        try {
            String urlStr = baseUrl + "/movie/" + movieId + "?api_key=" + apiKey;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return response.toString(); // Rückgabe der JSON-Antwort als String

            } else {
                System.out.println("Fehler beim Abrufen der Daten von TMDb: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Diese Methode holt die beliebtesten Filme und gibt die Informationen als String zurück
    public String fetchPopularMovies() {
        try {
            String urlStr = baseUrl + "/movie/popular?api_key=" + apiKey;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return response.toString(); // Rückgabe der JSON-Antwort als String

            } else {
                System.out.println("Fehler beim Abrufen der Daten von TMDb: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
