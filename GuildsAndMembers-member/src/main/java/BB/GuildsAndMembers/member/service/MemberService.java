package BB.GuildsAndMembers.member.service;

import BB.GuildsAndMembers.guild.entity.Guild;
import BB.GuildsAndMembers.guild.repository.GuildRepository;
import BB.GuildsAndMembers.guild.service.GuildService;
import BB.GuildsAndMembers.member.entity.Member;
import BB.GuildsAndMembers.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@ComponentScan("BB.GuildsAndMembers.repository")
public class MemberService {
    private final MemberRepository memberRepository;
    private final GuildRepository guildRepository;
    private final GuildService guildService;

    @Autowired
    public MemberService(MemberRepository memberRepository,
                         GuildRepository guildRepository,
                         GuildService guildService){
        this.memberRepository = memberRepository;
        this.guildRepository = guildRepository;
        this.guildService = guildService;
    }

    public Optional<Member> find(UUID id){
        return memberRepository.findById(id);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Optional<List<Member>> findAllByGuild(UUID guildId){
        //return memberRepository.findByGuild(guild);
        return guildRepository.findById(guildId)
                .map(memberRepository::findByGuild);
    }

    public void create(Member member){
        memberRepository.save(member);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public void delete(UUID id){
        memberRepository.findById(id).ifPresent(memberRepository::delete);
    }
}