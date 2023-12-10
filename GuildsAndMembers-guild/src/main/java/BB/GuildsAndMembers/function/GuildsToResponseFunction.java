package BB.GuildsAndMembers.function;

import BB.GuildsAndMembers.dto.GetGuildsResponse;
import BB.GuildsAndMembers.entity.Guild;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class GuildsToResponseFunction
        implements Function<List<Guild>, GetGuildsResponse> {

    @Override
    public GetGuildsResponse apply(List<Guild> guilds) {
        return GetGuildsResponse.builder()
                .guilds(guilds.stream()
                        .map(guild -> GetGuildsResponse.Guild.builder()
                                .id(guild.getGuildId())
                                .name(guild.getName())
                                .build())
                        .toList())
                .build();
    }
}

