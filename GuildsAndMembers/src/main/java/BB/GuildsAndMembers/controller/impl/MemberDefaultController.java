package BB.GuildsAndMembers.controller.impl;

import BB.GuildsAndMembers.controller.api.MemberController;
import BB.GuildsAndMembers.dto.member.MemberCollectionDto;
import BB.GuildsAndMembers.dto.member.MemberDto;
import BB.GuildsAndMembers.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/members")
public class MemberDefaultController implements MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberDefaultController(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public ResponseEntity<MemberDto> getMember(@PathVariable UUID id) {
        MemberDto member = memberService.findById(id);
        return ResponseEntity.ok().body(member);
    }

    @Override
    public ResponseEntity<List<MemberCollectionDto>> getAllMembers() {
        List<MemberCollectionDto> members = memberService.findAll();
        return ResponseEntity.ok().body(members);
    }

    @Override
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        MemberDto createdMember = memberService.save(memberDto);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MemberDto> updateMember(
            @PathVariable UUID id, @RequestBody MemberDto memberDto) {
        if (!id.equals(memberDto.getId())) {
            return ResponseEntity.badRequest().build();
        }

        MemberDto updatedMember = memberService.save(memberDto);
        return ResponseEntity.ok().body(updatedMember);
    }

    @Override
    public ResponseEntity<Void> deleteMember(@PathVariable UUID id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
