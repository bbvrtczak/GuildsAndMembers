package BB.GuildsAndMembers.dto.member;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class MemberCollectionDto {
    private UUID id;
    private String name;
}
