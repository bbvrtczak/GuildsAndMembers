package BB.GuildsAndMembers.controller.impl;

import BB.GuildsAndMembers.controller.api.GuildController;
import BB.GuildsAndMembers.dto.GetGuildResponse;
import BB.GuildsAndMembers.dto.GetGuildsResponse;
import BB.GuildsAndMembers.function.GuildToResponseFunction;
import BB.GuildsAndMembers.function.GuildsToResponseFunction;
import BB.GuildsAndMembers.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class GuildDefaultController implements GuildController {
    private final GuildService service;
    private final GuildToResponseFunction guildToResponse;
    private final GuildsToResponseFunction guildsToResponse;


    @Autowired
    public GuildDefaultController(GuildService service,
                                  GuildToResponseFunction guildToResponse,
                                  GuildsToResponseFunction guildsToResponse) {
        this.service = service;
        this.guildToResponse = guildToResponse;
        this.guildsToResponse = guildsToResponse;
    }

    public GetGuildsResponse getGuilds() {
        return guildsToResponse.apply(service.findAll());
    }

    @Override
    public GetGuildResponse getGuild(UUID id) {
        return service.find(id)
                .map(guildToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteGuild(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}