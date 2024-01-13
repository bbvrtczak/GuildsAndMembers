package BB.GuildsAndMembers.initialize;

import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.service.GuildService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    /**
     * Service for guilds operations.
     */
    private final GuildService guildService;

    /**
     * @param guildService service for managing guilds
     */
    @Autowired
    public InitializeData(GuildService guildService) {
        this.guildService = guildService;
    }

    @Override
    public void afterPropertiesSet() {
        if(guildService.findAll().isEmpty()){
            Guild dungeonDonutsGuild = Guild.builder()
                    .guildId(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                    .name("DungeonDonuts")
                    .region("EU")
                    .creationYear(2020)
                    .build();

            Guild RNGsquad = Guild.builder()
                    .guildId(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                    .name("RNGSquad")
                    .region("EU")
                    .creationYear(2020)
                    .build();

            guildService.create(dungeonDonutsGuild);
            guildService.create(RNGsquad);
        }
    }
}
