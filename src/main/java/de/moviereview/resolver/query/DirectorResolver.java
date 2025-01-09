package de.moviereview.resolver.query;

import de.moviereview.domain.model.Director;
import de.moviereview.domain.service.DirectorService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class DirectorResolver implements GraphQLQueryResolver {

    private final DirectorService directorService;

    public DirectorResolver(DirectorService directorService) {
        this.directorService = directorService;
    }

    // Query: Fetch all directors
    public List<Director> getDirectors() {
        return directorService.getAllDirectors();
    }

    // Query: Fetch director by ID
    public Director getDirectorById(Long id) {
        return directorService.getDirectorById(id);
    }
}
