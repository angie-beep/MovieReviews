package de.moviereviews.infrastructure.api.graphql.resolver.query;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class QueryResolver{
    @QueryMapping
    public String hello() {
        return "Hello, world!";
    }
}

