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
			@Value("${gm.member.url}") String memberUrl,
			@Value("${gm.guild.url}") String guildUrl,
			@Value("${gm.gateway.host}") String host
	){
		return builder
				.routes()
				.route("guilds", route -> route
						.host(host)
						.and()
						.path(
								"/api/guilds/{uuid}",
								"/api/guilds"
						)
						.uri(guildUrl)
				)
				.route("members", route -> route
						.host(host)
						.and()
						.path(
								"/api/members",
								"/api/members/**",
								"/api/guilds/{uuid}/members",
								"/api/guilds/{uuid}/members/**"
						)
						.uri(memberUrl)
				)
				.build();
	}
}
