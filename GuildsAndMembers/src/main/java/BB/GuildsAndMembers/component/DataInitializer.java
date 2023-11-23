package BB.GuildsAndMembers.component;

import BB.GuildsAndMembers.dto.guild.GuildDto;
import BB.GuildsAndMembers.dto.member.MemberDto;
import BB.GuildsAndMembers.service.GuildService;
import BB.GuildsAndMembers.service.MemberService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final GuildService guildService;
    private final MemberService memberService;

    @Autowired
    public DataInitializer(GuildService guildService,
                           MemberService memberService) {
        this.guildService = guildService;
        this.memberService = memberService;
    }

    @PostConstruct
    public void initializeData(){
        GuildDto dungeonDonutsGuild = guildService.save(
                GuildDto.builder()
                .name("DungeonDonuts")
                .region("EU")
                .creationYear(2020)
                .build());

        GuildDto RNGsquad = guildService.save(
                GuildDto.builder()
                .name("RNGsquad")
                .region("US")
                .creationYear(2019)
                .build());

        MemberDto HilariousHedgehog = MemberDto.builder()
                .name("HilarousHedgehog")
                .role("Mage")
                .guildId(dungeonDonutsGuild.getId())
                .build();

        MemberDto GarryDestroyer = MemberDto.builder()
                .name("GarryDestroyer")
                .role("Soldier")
                .guildId(dungeonDonutsGuild.getId())
                .build();

        MemberDto HimmeGoes69 = MemberDto.builder()
                .name("HimmeGoes69")
                .role("Mage")
                .guildId(RNGsquad.getId())
                .build();

        memberService.save(HilariousHedgehog);
        memberService.save(GarryDestroyer);
        memberService.save(HimmeGoes69);
    }
}