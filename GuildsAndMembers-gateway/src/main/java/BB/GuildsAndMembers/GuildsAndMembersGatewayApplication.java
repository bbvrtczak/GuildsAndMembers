package BB.GuildsAndMembers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


import java.util.Arrays;
import java.util.Collections;

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

	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
