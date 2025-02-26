package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.domain.model.Review;
import de.moviereviews.domain.service.ReviewService;
import de.moviereviews.infrastructure.api.dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewQueryResolverTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewQueryResolver reviewQueryResolver;

    @Test
    void testGetUserReviews() {
        // Arrange
        Review review = new Review();
        review.setComment("Great movie!");

        when(reviewService.getReviewsByUserId(1L)).thenReturn(Arrays.asList(review));

        // Act
        Set<ReviewDTO> result = reviewQueryResolver.getUserReviews(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(reviewService, times(1)).getReviewsByUserId(1L);
    }
}
