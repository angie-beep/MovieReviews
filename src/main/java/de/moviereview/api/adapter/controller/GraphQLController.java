package de.moviereview.api.adapter.controller;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.kickstart.execution.GraphQLInvoker;
import graphql.kickstart.execution.input.GraphQLInvocationInput;
import graphql.kickstart.execution.input.GraphQLSingleInvocationInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public GraphQLController(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @PostMapping("/graphql")
    public ResponseEntity<Object> executeGraphQL(@RequestBody Map<String, Object> request) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query((String) request.get("query"))
                .variables((Map<String, Object>) request.getOrDefault("variables", Map.of()))
                .build();

        ExecutionResult executionResult = graphQL.execute(executionInput);
        return ResponseEntity.ok(executionResult.toSpecification());
    }
}
