package BB.GuildsAndMembers.guild.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface GuildController {
    @DeleteMapping("/api/guilds/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGuild(
            @PathVariable("id")
            UUID id
    );
}
