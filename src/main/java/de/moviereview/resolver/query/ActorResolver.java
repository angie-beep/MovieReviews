package de.moviereview.resolver.query;

import de.moviereview.domain.model.Actor;
import de.moviereview.domain.service.ActorService;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;


//lese zugriff auf daten mit graphql

public class ActorResolver implements GraphQLQueryResolver{
    private final ActorService actorService;

    // Constructor-based dependency injection
    public ActorResolver(ActorService actorService) {
        this.actorService = actorService;
    }

    // Query: Fetch all actors
    public List<Actor> getActors() {
        return actorService.getAllActors();
    }

    // Query: Fetch actor by ID
    public Actor getActorById(Long id) {
        return actorService.getActorById(id);
    }

    // Mutation: Add a new actor
    //public Actor addActor(String name) {
    //    return actorService.addActor(name);
    //}

}
