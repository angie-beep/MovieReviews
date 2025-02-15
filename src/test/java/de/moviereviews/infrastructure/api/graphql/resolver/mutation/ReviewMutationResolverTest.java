package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import de.moviereviews.infrastructure.api.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewMutationResolverTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewMutationResolver reviewMutationResolver;


    @Test
    void testUpdateReview() {
        // Arrange
        Review review = new Review();
        review.setId(1L);
        review.setStarRating(4);
        review.setComment("Great movie!");

        when(reviewService.updateReview(1L, 4, "Great movie!"))
                .thenReturn(review);

        // Act
        ReviewDTO result = reviewMutationResolver.updateReview(1L, 4, "Great movie!");

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(4, result.getStarRating());
        assertEquals("Great movie!", result.getComment());

        verify(reviewService, times(1)).updateReview(1L, 4, "Great movie!");
    }

    @Test
    void testDeleteReview() {
        // Arrange
        when(reviewService.deleteReview(1L)).thenReturn(true);

        // Act
        Boolean result = reviewMutationResolver.deleteReview(1L);

        // Assert
        assertTrue(result);
        verify(reviewService, times(1)).deleteReview(1L);
    }
}
