package de.moviereviews.infrastructure.api.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import de.moviereviews.domain.model.Actor;
import de.moviereviews.domain.service.ActorService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ActorQueryResolver implements GraphQLQueryResolver {

    private final ActorService actorService;

    public ActorQueryResolver(ActorService actorService) {
        this.actorService = actorService;
    }

    public List<Actor> getActors() {
        return actorService.getAllActors();
    }

    public Actor getActorById(Long id) {
        return actorService.getActorById(id);
    }
}
