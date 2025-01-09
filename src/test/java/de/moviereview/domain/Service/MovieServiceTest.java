package de.moviereview.domain.Service;
import de.moviereview.domain.service.MovieService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void shouldCalculateAverageRating() {
        MovieService service = new MovieService();
        List<Integer> ratings = List.of(5, 4, 3, 4, 5);
        double average = service.calculateAverageRating(ratings);
        assertEquals(4.2, average, 0.01);
    }

    @Test
    void shouldReturnZeroForNoRatings() {
        MovieService service = new MovieService();
        List<Integer> ratings = List.of();
        double average = service.calculateAverageRating(ratings);
        assertEquals(0.0, average);
    }
}


