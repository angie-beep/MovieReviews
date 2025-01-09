package de.moviereview.domain.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.moviereview.domain.model.Movie;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMDbService {

    private final String apiKey = "0e14c15b7f0b81396f35e3f9c93f3f8c"; // Dein API Key hier
    private final String baseUrl = "https://api.themoviedb.org/3";

    // Fetch movie details by TMDb ID and parse it into a Movie object
    public Movie fetchMovieDetails(Long movieId) {
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

                return parseMovieFromJson(response.toString());

            } else {
                System.out.println("Error fetching data from TMDb: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Parse JSON data into a Movie object
    private Movie parseMovieFromJson(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            Movie movie = new Movie();
            movie.setTitle(rootNode.get("title").asText());
            movie.setSummary(rootNode.get("overview").asText());
            movie.setTrailer("https://www.youtube.com/watch?v=" + rootNode.get("video").asText()); // Placeholder
            movie.setPublishingDate(java.time.LocalDate.parse(rootNode.get("release_date").asText()));
            movie.setLength(rootNode.get("runtime").asInt());
            movie.setOriginalLanguage(rootNode.get("original_language").asText());
            movie.setOverallRating(rootNode.get("vote_average").asDouble());

            return movie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Fetch popular movies and return a list of JSON responses
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

                return response.toString(); // Return JSON response as String

            } else {
                System.out.println("Error fetching data from TMDb: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
