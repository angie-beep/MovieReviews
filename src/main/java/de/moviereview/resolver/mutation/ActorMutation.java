package de.moviereview.resolver.mutation;

import de.moviereview.domain.model.Actor;
import de.moviereview.domain.service.ActorService;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class ActorMutation implements GraphQLMutationResolver {

    private final ActorService actorService;

    // Constructor-based dependency injection
    public ActorMutation(ActorService actorService) {
        this.actorService = actorService;
    }

    // Add a new actor
    public Actor addActor(String firstname, String lastname, String birthday, String heritage) {
        return actorService.addActor(firstname, lastname, birthday, heritage);
    }
}
