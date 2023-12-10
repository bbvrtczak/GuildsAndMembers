package BB.GuildsAndMembers.member.controller.api;

import BB.GuildsAndMembers.member.dto.GetMemberResponse;
import BB.GuildsAndMembers.member.dto.GetMembersResponse;
import BB.GuildsAndMembers.member.dto.PutMemberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface MemberController {
    @GetMapping("api/members")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMembersResponse getMembers();

    @GetMapping("/api/guilds/{guildId}/members")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMembersResponse getGuildMembers(
            @PathVariable("guildId")
            UUID guildId
    );

    @GetMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMemberResponse getMember(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMember(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutMemberRequest request
    );

    @DeleteMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMember(
            @PathVariable("id")
            UUID id
    );
}
