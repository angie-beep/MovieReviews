package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DirectorQueryResolver implements GraphQLQueryResolver {

    private final DirectorService directorService;

    public DirectorQueryResolver(DirectorService directorService) {
        this.directorService = directorService;
    }

    public List<Director> getDirectors() {
        return directorService.getAllDirectors();
    }

    public Director getDirectorById(Long id) {
        return directorService.getDirectorById(id);
    }
}
