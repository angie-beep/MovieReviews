package de.moviereview.infrastructure.api.controller;

import de.moviereview.domain.model.Actor;
import de.moviereview.domain.service.ActorService;
import de.moviereview.infrastructure.api.dto.ActorDTO;
import de.moviereview.infrastructure.api.mapper.ActorMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    public void listActors() {
        List<ActorDTO> actors = actorService.getAllActors().stream()
                .map(ActorMapper::toDto)
                .toList();
        actors.forEach(actor -> System.out.println("Actor: " + actor.getFirstname() + " " + actor.getLastname()));
    }

    public void addActor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Birthday (YYYY-MM-DD): ");
        LocalDate birthday = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Heritage: ");
        String heritage = scanner.nextLine();

        ActorDTO actorDto = new ActorDTO();
        actorDto.setFirstname(firstName);
        actorDto.setLastname(lastName);
        actorDto.setBirthday(birthday);
        actorDto.setHeritage(heritage);

        Actor actor = ActorMapper.toModel(actorDto);
        actorService.saveActor(actor);
    }
}
