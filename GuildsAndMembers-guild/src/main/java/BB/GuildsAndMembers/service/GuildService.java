package BB.GuildsAndMembers.service;

import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.event.api.GuildEventRepository;
import BB.GuildsAndMembers.repository.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@ComponentScan("BB.GuildsAndMembers.repository")
public class GuildService {
    private final GuildRepository repository;
    private final GuildEventRepository eventRepository;

    @Autowired
    public GuildService(GuildRepository guildRepository,
                        GuildEventRepository eventRepository){
        this.repository = guildRepository;
        this.eventRepository = eventRepository;
    }

    public List<Guild> findAll() {
        return repository.findAll();
    }

    public Optional<Guild> find(UUID id) {
        return repository.findById(id);
    }

    public Optional<Guild> find(String name) {
        return repository.findByName(name);
    }

    public void create(Guild guild) {
        repository.save(guild);
    }

    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
