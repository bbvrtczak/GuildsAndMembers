package BB.GuildsAndMembers.controller.api;

import BB.GuildsAndMembers.dto.GetGuildResponse;
import BB.GuildsAndMembers.dto.GetGuildsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface GuildController {
    @GetMapping("api/users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGuildsResponse getUsers();

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetGuildResponse getUser(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(
            @PathVariable("id")
            UUID id
    );
}