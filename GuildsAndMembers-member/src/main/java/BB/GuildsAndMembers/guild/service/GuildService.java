package BB.GuildsAndMembers.guild.service;

import BB.GuildsAndMembers.guild.repository.GuildRepository;
import BB.GuildsAndMembers.guild.entity.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GuildService {
    private final GuildRepository repository;

    @Autowired
    public GuildService(GuildRepository repository){
        this.repository = repository;
    }

    public Optional<Guild> find(UUID id){
        return repository.findById(id);
    }

    public void create(Guild guild){
        repository.save(guild);
    }

    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }
}
