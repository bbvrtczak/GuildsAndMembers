package BB.GuildsAndMembers.dto.member;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class MemberDto {
    private UUID id;
    private String name;
    private String role;
    private UUID guildId;
}