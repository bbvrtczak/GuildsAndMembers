package BB.GuildsAndMembers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuildsAndMembersGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuildsAndMembersGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${gm.guild.url}") String guildUrl,
			@Value("${gm.member.url}") String memberUrl,
			//@Value("${rpg.user.url}") String userUrl,
			@Value("${gm.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("guilds", route -> route
						.path(
								"/api/guilds/{uuid}",
								"/api/guilds"
						)
						.uri(guildUrl)
				)
//				.route("professions", route -> route
//						.host(host)
//						.and()
//						.path(
//								"/api/professions/{uuid}",
//								"/api/professions"
//						)
//						.uri(professionUrl)
//				)
				.route("members", route -> route
						.path(
								"/api/members",
								"/api/members/**"
//								"/api/users/{uuid}/characters",
//								"/api/users/{uuid}/characters/**",
//								"/api/professions/{uuid}/characters",
//								"/api/professions/{uuid}/characters/**"
						)
						.uri(memberUrl)
				)
				.build();
	}
}
