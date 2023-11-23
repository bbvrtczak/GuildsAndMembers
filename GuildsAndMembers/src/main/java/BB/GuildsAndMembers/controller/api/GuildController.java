package BB.GuildsAndMembers.controller.api;

import BB.GuildsAndMembers.dto.guild.GuildCollectionDto;
import BB.GuildsAndMembers.dto.guild.GuildDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface GuildController {

    @GetMapping("/{id}")
    ResponseEntity<GuildDto> getGuild(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<GuildCollectionDto>> getAllGuilds();

    @PostMapping
    ResponseEntity<GuildDto> createGuild(@RequestBody GuildDto guildDto);

    @PutMapping("/{id}")
    ResponseEntity<GuildDto> updateGuild(
            @PathVariable UUID id, @RequestBody GuildDto guildDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGuild(@PathVariable UUID id);
}