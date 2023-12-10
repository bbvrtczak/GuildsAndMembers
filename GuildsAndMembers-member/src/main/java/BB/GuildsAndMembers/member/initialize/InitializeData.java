package BB.GuildsAndMembers.member.initialize;

import BB.GuildsAndMembers.guild.service.GuildService;
import BB.GuildsAndMembers.member.entity.Member;
import BB.GuildsAndMembers.member.service.MemberService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            Member HilariousHedgehog = Member.builder()
                    .name("HilarousHedgehog")
                    .role("Mage")
                    .build();

            Member GarryDestroyer = Member.builder()
                    .name("GarryDestroyer")
                    .role("Soldier")
                    .build();

            Member HimmeGoes69 = Member.builder()
                    .name("HimmeGoes69")
                    .role("Mage")
                    .build();

            memberService.create(HilariousHedgehog);
            memberService.create(GarryDestroyer);
            memberService.create(HimmeGoes69);
        }
    }
}
