package BB.GuildsAndMembers.function;

import BB.GuildsAndMembers.dto.GetGuildResponse;
import BB.GuildsAndMembers.entity.Guild;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GuildToResponseFunction implements Function<Guild, GetGuildResponse> {

    @Override
    public GetGuildResponse apply(Guild guild) {
        return GetGuildResponse.builder()
                .id(guild.getGuildId())
                .name(guild.getName())
                .region(guild.getRegion())
                .creationYear(guild.getCreationYear())
                .build();
    }
}

