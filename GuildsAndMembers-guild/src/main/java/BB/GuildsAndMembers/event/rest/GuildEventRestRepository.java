package BB.GuildsAndMembers.event.rest;

import BB.GuildsAndMembers.event.api.GuildEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class GuildEventRestRepository implements GuildEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public GuildEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/guilds/{id}", id);
    }

}
