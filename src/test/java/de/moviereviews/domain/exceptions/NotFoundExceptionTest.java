package de.moviereviews.domain.exceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class NotFoundExceptionTest {
    @Test
    void testExceptionMessage() {
        // Arrange & Act
        NotFoundException exception = new NotFoundException("Movie not found");

        // Assert
        assertNotNull(exception);
        assertEquals("Movie not found", exception.getMessage());
    }
}
