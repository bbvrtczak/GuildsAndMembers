package BB.GuildsAndMembers.service;

import BB.GuildsAndMembers.dto.member.MemberCollectionDto;
import BB.GuildsAndMembers.dto.member.MemberDto;
import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.entity.Member;
import BB.GuildsAndMembers.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@ComponentScan("BB.GuildsAndMembers.repository")
public class MemberService {
    private final MemberRepository memberRepository;
    private final GuildService guildService;

    @Autowired
    public MemberService(MemberRepository memberRepository,
                         GuildService guildService){
        this.memberRepository = memberRepository;
        this.guildService = guildService;
    }

    public List<MemberCollectionDto> findMembersByGuild(Guild guild){
        List<Member> members = memberRepository.findByGuild(guild);
        return members.stream()
                .map(this::convertToMemberCollectionDTO)
                .collect(Collectors.toList());
    }

    public void delete(UUID id){
        memberRepository.deleteById(id);
    }

    public MemberDto findById(UUID id){
        Member member =  memberRepository.findById(id).orElse(null);
        return convertToMemberDto(member);
    }

    public MemberDto save(MemberDto memberDto){
        Member member = convertToEntity(memberDto);
        Member saved = memberRepository.save(member);
        return convertToMemberDto(saved);
    }

    public List<MemberCollectionDto> findAll(){
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(this::convertToMemberCollectionDTO)
                .collect(Collectors.toList());
    }

    private MemberCollectionDto convertToMemberCollectionDTO(Member member) {
        return MemberCollectionDto.builder()
                .id(member.getMemberId())
                .name(member.getName())
                .build();
    }

    private MemberDto convertToMemberDto(Member member){
        return MemberDto.builder()
                .id(member.getMemberId())
                .name(member.getName())
                .role(member.getRole())
                .guildId(member.getGuild().getGuildId())
                .build();
    }

    private Member convertToEntity(MemberDto memberDto) {
        return Member.builder()
                .memberId(memberDto.getId())
                .name(memberDto.getName())
                .role(memberDto.getRole())
                .guild(guildService.convertToEntity(guildService.findById(memberDto.getGuildId())))
                .build();
    }
}