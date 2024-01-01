package BB.GuildsAndMembers.controller.api;

import BB.GuildsAndMembers.dto.GetGuildResponse;
import BB.GuildsAndMembers.dto.GetGuildsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface GuildController {
    @GetMapping("api/guilds")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGuildsResponse getGuilds();

    @GetMapping("/api/guilds/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGuildResponse getGuild(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/guilds/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGuild(
            @PathVariable("id")
            UUID id
    );
}