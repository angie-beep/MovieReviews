package de.moviereviews.domain.exceptions;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        // Filtern und Umwandeln der Fehler, z. B. nur die NotFoundExceptions herausfiltern
        return errors.stream()
                .map(error -> /* eigene Transformation */ error)
                .collect(Collectors.toList());
    }
}
