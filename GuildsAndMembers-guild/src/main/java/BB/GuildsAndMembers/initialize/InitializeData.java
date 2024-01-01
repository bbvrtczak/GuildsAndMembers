package BB.GuildsAndMembers.initialize;

import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.service.GuildService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                    .name("DungeonDonuts")
                    .region("EU")
                    .creationYear(2020)
                    .build();

            Guild RNGsquad = Guild.builder()
                    .name("RNGSquad")
                    .region("EU")
                    .creationYear(2020)
                    .build();

            guildService.create(dungeonDonutsGuild);
            guildService.create(RNGsquad);
        }
    }
}
