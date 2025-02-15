package de.moviereviews.infrastructure.api.graphql.resolver.query;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.infrastructure.api.dto.DirectorDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import de.moviereviews.infrastructure.mapper.DirectorMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;

@Controller
public class DirectorQueryResolver {

    private final DirectorService directorService;

    public DirectorQueryResolver(DirectorService directorService) {
        this.directorService = directorService;
    }
    @QueryMapping
    public Set<DirectorDTO> getDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return directors.stream()
                .map(DirectorMapper::toDTO)
                .collect(Collectors.toSet());
    }
    @QueryMapping
    public DirectorDTO getDirectorById(Long id) {
        return DirectorMapper.toDTO(directorService.getDirectorById(id));
    }
}
