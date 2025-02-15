package de.moviereviews.infrastructure.api.graphql.resolver.mutation;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import de.moviereviews.infrastructure.api.dto.ActorDTO;
import de.moviereviews.infrastructure.mapper.ActorMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ActorMutationResolver {

    private final ActorService actorService;

    public ActorMutationResolver(ActorService actorService) {
        this.actorService = actorService;
    }
    @MutationMapping
    public ActorDTO addActor(String firstName, String lastName, String birthday, String heritage) {
        Actor actor = actorService.addActor(firstName, lastName, birthday, heritage);
        return ActorMapper.toDTO(actor);
    }
}
