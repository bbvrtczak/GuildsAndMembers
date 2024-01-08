package BB.GuildsAndMembers.member.function;

import BB.GuildsAndMembers.member.dto.GetMemberResponse;
import BB.GuildsAndMembers.member.entity.Member;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MemberToResponseFunction implements Function<Member, GetMemberResponse> {
    @Override
    public GetMemberResponse apply(Member entity) {
        return GetMemberResponse.builder()
                .id(entity.getMemberId())
                .name(entity.getName())
                .role(entity.getRole())
//                .guildId(entity.getGuild().getId())
                .build();
    }
}
