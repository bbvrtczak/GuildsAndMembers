package BB.GuildsAndMembers.service;

import BB.GuildsAndMembers.dto.guild.GuildCollectionDto;
import BB.GuildsAndMembers.dto.guild.GuildDto;
import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.repository.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@ComponentScan("BB.GuildsAndMembers.repository")
public class GuildService {
    private final GuildRepository guildRepository;

    @Autowired
    public GuildService(GuildRepository guildRepository){
        this.guildRepository = guildRepository;
    }

    public GuildDto save(GuildDto guildDto) {
        Guild guild = convertToEntity(guildDto);
        Guild savedGuild = guildRepository.save(guild);
        return convertToDto(savedGuild);
    }

    public void delete(UUID id){
        Guild guild = guildRepository.findById(id).orElse(null);
        System.out.println(guild);
        if (guild != null) {
            guildRepository.delete(guild);
        }
    }

    public GuildDto findById(UUID id){
        Guild guild = guildRepository.findById(id).orElse(null);
        if (guild == null){
            return null;
        }
        return convertToDto(guild);
    }

    public List<GuildCollectionDto> findAll(){
        List<Guild> guilds = guildRepository.findAll();
        return guilds.stream()
                .map(this::convertToGuildCollectionDTO)
                .collect(Collectors.toList());
    }

    public GuildDto findByName(String name){
        Guild guild = guildRepository.findByName(name).orElse(null);
        return convertToDto(guild);
    }

    private GuildDto convertToDto(Guild guild) {
        return GuildDto.builder()
                .id(guild.getGuildId())
                .name(guild.getName())
                .region(guild.getRegion())
                .creationYear(guild.getCreationYear())
                .build();
    }

    public Guild convertToEntity(GuildDto guildDto) {
        return Guild.builder()
                .guildId(guildDto.getId())
                .name(guildDto.getName())
                .region(guildDto.getRegion())
                .creationYear(guildDto.getCreationYear())
                .build();
    }

    private GuildCollectionDto convertToGuildCollectionDTO(Guild guild) {
        return GuildCollectionDto.builder()
                .id(guild.getGuildId())
                .name(guild.getName())
                .build();
    }
}
