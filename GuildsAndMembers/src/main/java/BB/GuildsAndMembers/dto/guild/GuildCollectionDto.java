package BB.GuildsAndMembers.dto.guild;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class GuildCollectionDto {
    private UUID id;
    private String name;
}
