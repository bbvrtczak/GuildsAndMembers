package BB.GuildsAndMembers.controller.impl;

import BB.GuildsAndMembers.controller.api.GuildController;
import BB.GuildsAndMembers.dto.guild.GuildCollectionDto;
import BB.GuildsAndMembers.dto.guild.GuildDto;
import BB.GuildsAndMembers.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/guilds")
public class GuildDefaultController implements GuildController {
    private final GuildService guildService;

    @Autowired
    public GuildDefaultController(GuildService guildService) {
        this.guildService = guildService;
    }

    @Override
    public ResponseEntity<GuildDto> getGuild(@PathVariable UUID id) {
        GuildDto guild = guildService.findById(id);
        if (guild != null) {
            return ResponseEntity.ok().body(guild);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<GuildCollectionDto>> getAllGuilds() {
        List<GuildCollectionDto> guilds = guildService.findAll();
        return ResponseEntity.ok().body(guilds);
    }

    @Override
    public ResponseEntity<GuildDto> createGuild(
            @RequestBody GuildDto guildDto) {
        GuildDto createdGuild = guildService.save(guildDto);
        return new ResponseEntity<>(createdGuild, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GuildDto> updateGuild(
            @PathVariable UUID id, @RequestBody GuildDto guildDto) {
        if (!id.equals(guildDto.getId())) {
            return ResponseEntity.badRequest().build();
        }

        GuildDto updatedGuild = guildService.save(guildDto);
        return ResponseEntity.ok().body(updatedGuild);
    }

    @Override
    public ResponseEntity<Void> deleteGuild(@PathVariable UUID id) {
        guildService.delete(id);
        return ResponseEntity.noContent().build();
    }
}