package BB.GuildsAndMembers.function;

import BB.GuildsAndMembers.dto.PatchGuildRequest;
import BB.GuildsAndMembers.entity.Guild;

import java.util.function.BiFunction;

public class UpdateGuildWithRequestFunction
        implements BiFunction<Guild, PatchGuildRequest, Guild> {

    @Override
    public Guild apply(Guild entity, PatchGuildRequest request) {
        return Guild.builder()
                .guildId(entity.getGuildId())
                .name(request.getName())
                .region(entity.getRegion())
                .creationYear(entity.getCreationYear())
                .build();
    }
}

