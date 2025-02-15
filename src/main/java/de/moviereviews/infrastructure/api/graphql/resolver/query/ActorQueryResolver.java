package de.moviereviews.infrastructure.api.graphql.resolver.query;

import de.moviereviews.infrastructure.api.dto.ActorDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActorQueryResolver implements GraphQLQueryResolver {

    private final ActorService actorService;

    public ActorQueryResolver(ActorService actorService) {
        this.actorService = actorService;
    }

    public Set<ActorDTO> getActors() {
        List<Actor> actors = actorService.getAllActors();
        return actors.stream()
                .map(ActorMapper::toDTO)
                .collect(Collectors.toSet());
    }


    public ActorDTO getActorById(Long id) {
        return ActorMapper.toDTO(actorService.getActorById(id));
    }
}
