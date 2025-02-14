package de.moviereviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "de.moviereviews.infrastructure.api.servlet")

public class MovieReviewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieReviewsApplication.class, args);
    }
}
