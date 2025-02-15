package de.moviereviews.infrastructure.api.graphql.resolver.mutation;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import de.moviereviews.domain.model.Director;
import de.moviereviews.domain.service.DirectorService;
import de.moviereviews.infrastructure.api.dto.DirectorDTO;
import de.moviereviews.infrastructure.mapper.DirectorMapper;
import de.moviereviews.infrastructure.persistence.entity.DirectorEntity;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class DirectorMutationResolver {

    private final DirectorService directorService;

    public DirectorMutationResolver(DirectorService directorService) {
        this.directorService = directorService;
    }
    @MutationMapping
    public DirectorDTO addDirector(String firstName, String lastName, String birthday, String heritage) {
        Director director = directorService.addDirector(firstName, lastName, birthday, heritage);
        return DirectorMapper.toDTO(director);
    }
}
