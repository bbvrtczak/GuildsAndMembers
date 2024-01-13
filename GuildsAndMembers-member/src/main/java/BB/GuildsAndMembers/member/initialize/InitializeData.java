package BB.GuildsAndMembers.member.initialize;

import BB.GuildsAndMembers.guild.entity.Guild;
import BB.GuildsAndMembers.guild.service.GuildService;
import BB.GuildsAndMembers.member.entity.Member;
import BB.GuildsAndMembers.member.service.MemberService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final GuildService guildService;
    private final MemberService memberService;

    /**
     * @param guildService service for managing guilds
     * @param memberService service for managing members
     */
    @Autowired
    public InitializeData(GuildService guildService,
                          MemberService memberService) {
        this.guildService = guildService;
        this.memberService = memberService;
    }

    @Override
    public void afterPropertiesSet() {
        if(memberService.findAll().isEmpty()){
            Guild DungeonDonuts = Guild.builder()
                    .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                    .build();

            Guild RNGSquad = Guild.builder()
                    .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                    .build();

            guildService.create(DungeonDonuts);
            guildService.create(RNGSquad);

            Member HilariousHedgehog = Member.builder()
                    .memberId(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .name("HilariousHedgehog")
                    .role("Mage")
                    .guild(DungeonDonuts)
                    .build();

            Member GarryDestroyer = Member.builder()
                    .memberId(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                    .name("GarryDestroyer")
                    .role("Soldier")
                    .guild(DungeonDonuts)
                    .build();

            Member HimmeGoes69 = Member.builder()
                    .memberId(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                    .name("HimmeGoes69")
                    .role("Mage")
                    .guild(RNGSquad)
                    .build();

            memberService.create(HilariousHedgehog);
            memberService.create(GarryDestroyer);
            memberService.create(HimmeGoes69);
        }
    }
}
