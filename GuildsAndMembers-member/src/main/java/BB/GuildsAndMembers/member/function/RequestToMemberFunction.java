package BB.GuildsAndMembers.member.function;

import BB.GuildsAndMembers.member.dto.PutMemberRequest;
import BB.GuildsAndMembers.member.entity.Member;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMemberFunction
        implements BiFunction<UUID, PutMemberRequest, Member> {

    @Override
    public Member apply(UUID id, PutMemberRequest request) {
        return Member.builder()
                .memberId(id)
                .name(request.getName())
                .role(request.getRole())
                .build();
    }
}

