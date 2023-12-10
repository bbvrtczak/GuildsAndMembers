package BB.GuildsAndMembers.member.function;

import BB.GuildsAndMembers.member.dto.PatchMemberRequest;
import BB.GuildsAndMembers.member.entity.Member;

import java.util.function.BiFunction;

public class UpdateMemberWithRequestFunction
        implements BiFunction<Member, PatchMemberRequest, Member> {

    @Override
    public Member apply(Member entity, PatchMemberRequest request) {
        return Member.builder()
                .memberId(entity.getMemberId())
                .name(request.getName())
                .build();
    }
}
