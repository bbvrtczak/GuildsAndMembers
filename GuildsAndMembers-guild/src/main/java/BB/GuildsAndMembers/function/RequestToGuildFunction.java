package BB.GuildsAndMembers.function;

import BB.GuildsAndMembers.dto.PutGuildRequest;
import BB.GuildsAndMembers.entity.Guild;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToGuildFunction
        implements BiFunction<UUID, PutGuildRequest, Guild> {

    @Override
    public Guild apply(UUID id, PutGuildRequest request) {
        return Guild.builder()
                .guildId(id)
                .name(request.getName())
                .region(request.getRegion())
                .creationYear(request.getCreationYear())
                .build();
    }
}
