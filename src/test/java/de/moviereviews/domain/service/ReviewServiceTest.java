package de.moviereviews.domain.service;

import de.moviereviews.domain.model.Review;
import de.moviereviews.infrastructure.mapper.ReviewMapper;
import de.moviereviews.infrastructure.persistence.entity.ReviewEntity;
import de.moviereviews.infrastructure.persistence.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    private ReviewEntity reviewEntity;
    private Review review;

    @BeforeEach
    void setUp() {
        reviewEntity = new ReviewEntity();
        reviewEntity.setId(1L);
        reviewEntity.setStarRating(5);
        reviewEntity.setComment("Great movie!");
        reviewEntity.setCreatedAt(LocalDateTime.now());

        review = ReviewMapper.toDomain(reviewEntity);
    }



    @Test
    void testUpdateReview_Found() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(reviewEntity));
        when(reviewRepository.save(any(ReviewEntity.class))).thenReturn(reviewEntity);

        Review updatedReview = reviewService.updateReview(1L, 4, "Good movie!");

        assertNotNull(updatedReview);
        assertEquals(4, updatedReview.getStarRating());
        assertEquals("Good movie!", updatedReview.getComment());
        verify(reviewRepository, times(1)).findById(1L);
        verify(reviewRepository, times(1)).save(any(ReviewEntity.class));
    }

    @Test
    void testUpdateReview_NotFound() {
        when(reviewRepository.findById(99L)).thenReturn(Optional.empty());

        Review updatedReview = reviewService.updateReview(99L, 4, "Good movie!");

        assertNull(updatedReview);
        verify(reviewRepository, times(1)).findById(99L);
        verify(reviewRepository, never()).save(any(ReviewEntity.class));
    }

    @Test
    void testDeleteReview() {
        doNothing().when(reviewRepository).deleteById(1L);

        Boolean result = reviewService.deleteReview(1L);

        assertTrue(result);
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetReviewsByUserId() {
        when(reviewRepository.findByUserId(1L)).thenReturn(Collections.singletonList(reviewEntity));

        List<Review> reviews = reviewService.getReviewsByUserId(1L);

        assertNotNull(reviews);
        assertEquals(1, reviews.size());
        assertEquals("Great movie!", reviews.get(0).getComment());
        verify(reviewRepository, times(1)).findByUserId(1L);
    }

    @Test
    void testGetReviewsByMovieId() {
        when(reviewRepository.findByMovieId(1L)).thenReturn(Collections.singletonList(reviewEntity));

        List<Review> reviews = reviewService.getReviewsByMovieId(1L);

        assertNotNull(reviews);
        assertEquals(1, reviews.size());
        assertEquals("Great movie!", reviews.get(0).getComment());
        verify(reviewRepository, times(1)).findByMovieId(1L);
    }
}
