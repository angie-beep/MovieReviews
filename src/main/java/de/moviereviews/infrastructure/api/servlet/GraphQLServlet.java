package de.moviereviews.infrastructure.api.servlet;

import de.moviereviews.infrastructure.api.graphql.resolver.mutation.*;
import de.moviereviews.infrastructure.api.graphql.resolver.query.*;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.apache.commons.io.IOUtils;
import jakarta.servlet.annotation.WebServlet;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@WebServlet(name = "GraphQLServlet", urlPatterns = {"/graphql/*"}, loadOnStartup = 1)
public class GraphQLServlet extends GraphQLHttpServlet {

    private final MovieQueryResolver movieQueryResolver;
    private final MovieMutationResolver movieMutationResolver;
    private final DirectorQueryResolver directorQueryResolver;
    private final DirectorMutationResolver directorMutationResolver;
    private final ActorQueryResolver actorQueryResolver;
    private final ActorMutationResolver actorMutationResolver;
    private final ReviewQueryResolver reviewQueryResolver;
    private final ReviewMutationResolver reviewMutationResolver;
    private final UserQueryResolver userQueryResolver;
    private final UserMutationResolver userMutationResolver;
    private final WatchlistQueryResolver watchlistQueryResolver;
    private final WatchlistMutationResolver watchlistMutationResolver;

    public GraphQLServlet(
            MovieQueryResolver movieQueryResolver,
            MovieMutationResolver movieMutationResolver,
            DirectorQueryResolver directorQueryResolver,
            DirectorMutationResolver directorMutationResolver,
            ActorQueryResolver actorQueryResolver,
            ActorMutationResolver actorMutationResolver,
            ReviewQueryResolver reviewQueryResolver,
            ReviewMutationResolver reviewMutationResolver,
            UserQueryResolver userQueryResolver,
            UserMutationResolver userMutationResolver,
            WatchlistQueryResolver watchlistQueryResolver,
            WatchlistMutationResolver watchlistMutationResolver
    ) {
        this.movieQueryResolver = movieQueryResolver;
        this.movieMutationResolver = movieMutationResolver;
        this.directorQueryResolver = directorQueryResolver;
        this.directorMutationResolver = directorMutationResolver;
        this.actorQueryResolver = actorQueryResolver;
        this.actorMutationResolver = actorMutationResolver;
        this.reviewQueryResolver = reviewQueryResolver;
        this.reviewMutationResolver = reviewMutationResolver;
        this.userQueryResolver = userQueryResolver;
        this.userMutationResolver = userMutationResolver;
        this.watchlistQueryResolver = watchlistQueryResolver;
        this.watchlistMutationResolver = watchlistMutationResolver;

        System.out.println("GraphQL Servlet gestartet!");


    }



    @Override
    protected GraphQLConfiguration getConfiguration() {

        return GraphQLConfiguration.with(createSchema()).build();
    }

    private GraphQLSchema createSchema() {
        try {
            final String schemaString = IOUtils.toString(
                    this.getClass().getResourceAsStream("/schema.graphqls")
            );

            return SchemaParser.newParser()
                    .schemaString(schemaString)
                    .resolvers(
                            movieQueryResolver, movieMutationResolver,
                            directorQueryResolver, directorMutationResolver,
                            actorQueryResolver, actorMutationResolver,
                            reviewQueryResolver, reviewMutationResolver,
                            userQueryResolver, userMutationResolver,
                            watchlistQueryResolver, watchlistMutationResolver
                    )
                    .build()
                    .makeExecutableSchema();
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

