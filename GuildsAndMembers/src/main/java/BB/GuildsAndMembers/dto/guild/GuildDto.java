package BB.GuildsAndMembers.dto.guild;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class GuildDto {
    private UUID id;
    private String name;
    private String region;
    private int creationYear;
}
