package BB.GuildsAndMembers.controller.api;

import BB.GuildsAndMembers.dto.member.MemberCollectionDto;
import BB.GuildsAndMembers.dto.member.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface MemberController {

    @GetMapping("/{id}")
    ResponseEntity<MemberDto> getMember(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<MemberCollectionDto>> getAllMembers();

    @PostMapping
    ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto);

    @PutMapping("/{id}")
    ResponseEntity<MemberDto> updateMember(
            @PathVariable UUID id, @RequestBody MemberDto memberDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMember(@PathVariable UUID id);
}
