package BB.GuildsAndMembers.member.controller.impl;

import BB.GuildsAndMembers.member.controller.api.MemberController;
import BB.GuildsAndMembers.member.dto.GetMemberResponse;
import BB.GuildsAndMembers.member.dto.GetMembersResponse;
import BB.GuildsAndMembers.member.dto.PutMemberRequest;
import BB.GuildsAndMembers.member.function.MemberToResponseFunction;
import BB.GuildsAndMembers.member.function.MembersToResponseFunction;
import BB.GuildsAndMembers.member.function.RequestToMemberFunction;
import BB.GuildsAndMembers.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class MemberDefaultController implements MemberController {
    private final MemberService service;
    private final MemberToResponseFunction memberToResponse;
    private final MembersToResponseFunction membersToResponse;
    private final RequestToMemberFunction requestToMember;

    @Autowired
    public MemberDefaultController(MemberService memberService,
                                   MemberToResponseFunction memberToResponse,
                                   MembersToResponseFunction membersToResponse,
                                   RequestToMemberFunction requestToMember) {
        this.service = memberService;
        this.memberToResponse = memberToResponse;
        this.membersToResponse = membersToResponse;
        this.requestToMember = requestToMember;
    }

    @Override
    public GetMembersResponse getMembers(){
        return membersToResponse.apply(service.findAll());
    }

    @Override
    public GetMembersResponse getGuildMembers(UUID guildId) {
        return service.findAllByGuild(guildId)
                .map(membersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMemberResponse getMember(UUID id) {
        return service.find(id)
                .map(memberToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putMember(UUID id, PutMemberRequest request) {
        service.create(requestToMember.apply(id, request));
    }


    @Override
    public void deleteMember(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        member -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}