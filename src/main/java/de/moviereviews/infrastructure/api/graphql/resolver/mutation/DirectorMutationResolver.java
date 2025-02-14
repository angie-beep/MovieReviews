package de.moviereviews.infrastructure.api.graphql.resolver.mutation;

import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class DirectorMutationResolver implements GraphQLMutationResolver {

    private final DirectorService directorService;

    public DirectorMutationResolver(DirectorService directorService) {
        this.directorService = directorService;
    }

    public Director addDirector(String firstName, String lastName, String birthday, String heritage) {
        return directorService.addDirector(firstName, lastName, birthday, heritage);
    }
}
