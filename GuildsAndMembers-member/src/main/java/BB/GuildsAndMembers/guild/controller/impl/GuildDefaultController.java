package BB.GuildsAndMembers.guild.controller.impl;

import BB.GuildsAndMembers.guild.controller.api.GuildController;
import BB.GuildsAndMembers.guild.service.GuildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class GuildDefaultController implements GuildController {
    private final GuildService service;

    public GuildDefaultController(GuildService service) {
        this.service = service;
    }

    @Override
    public void deleteGuild(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        guild -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
