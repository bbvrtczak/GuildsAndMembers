package BB.GuildsAndMembers.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class GuildCollectionDto {
    private UUID id;
    private String name;
}
