package BB.GuildsAndMembers.guild.repository;

import BB.GuildsAndMembers.guild.entity.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GuildRepository extends JpaRepository<Guild, UUID> {
}
