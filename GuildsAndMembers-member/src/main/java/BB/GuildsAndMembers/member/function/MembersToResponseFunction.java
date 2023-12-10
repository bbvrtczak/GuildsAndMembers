package BB.GuildsAndMembers.member.function;

import BB.GuildsAndMembers.member.dto.GetMembersResponse;
import BB.GuildsAndMembers.member.entity.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MembersToResponseFunction
        implements Function<List<Member>, GetMembersResponse> {

    @Override
    public GetMembersResponse apply(List<Member> entities) {
        return GetMembersResponse.builder()
                .members(entities.stream()
                        .map(member -> GetMembersResponse.Member.builder()
                                .id(member.getMemberId())
                                .name(member.getName())
                                .build())
                        .toList())
                .build();
    }
}

