package BB.GuildsAndMembers.component;

import BB.GuildsAndMembers.dto.guild.GuildDto;
import BB.GuildsAndMembers.dto.member.MemberDto;
import BB.GuildsAndMembers.service.GuildService;
import BB.GuildsAndMembers.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final GuildService guildService;
    private final MemberService memberService;

    public ApplicationRunner(GuildService guildService,
                             MemberService memberService) {
        this.guildService = guildService;
        this.memberService = memberService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        while (true){
            switch(scanner.next()){
                case "test": // testcase
                    System.out.println("test");
                    break;
                case "create-member":
                    CreateMember();
                    break;
                case "list-guilds":
                    guildService.findAll().forEach(System.out::println);
                    break;
                case "list-members":
                    memberService.findAll().forEach(System.out::println);
                    break;
                case "delete-member":
                    System.out.println("Give a member ID");
                    memberService.delete(UUID.fromString(scanner.next()));
                    break;
                case "menu":
                    displayMenu();
                    break;
                case "exit":
                    System.exit(0);
                    System.out.println("Quitting the application...");
                    break;
            }
        }
    }

    private void displayMenu(){
        System.out.println("Menu: (write a number and press enter)");
        //System.out.println("'test' - <testcase>");
        System.out.println("'create-member' -> Add member");
        System.out.println("'list-guilds' -> List all guilds");
        System.out.println("'list-members' -> List all members");
        System.out.println("'delete-member' -> Delete member");
        System.out.println("'menu' -> Show menu");
        System.out.println("'exit' -> Stop the application");
    }

    private void CreateMember(){
        Scanner scanner = new Scanner(System.in);
        String name;
        String role;
        String guild;
        System.out.println("Give a member name");
        name = scanner.next();
        System.out.println("Give a member role");
        role = scanner.next();
        System.out.println("Choose a guild:");
        guild = scanner.next();

        GuildDto actualGuild = guildService.findByName(guild);

        MemberDto tmpMember = MemberDto.builder()
                .name(name)
                .role(role)
                .guildId(actualGuild.getId())
                .build();
        memberService.save(tmpMember);
        System.out.println("Member created successfully");
    }
}
