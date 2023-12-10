package BB.GuildsAndMembers.repository;

import BB.GuildsAndMembers.entity.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository for guild entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface GuildRepository extends JpaRepository<Guild, UUID> {

    @Query("select g from Guild g")
    List<Guild> findAll();

    @Query("select g from Guild g where g.guildId = :id")
    Optional<Guild> findById(@Param("id") UUID id);

    @Modifying
    @Query("delete from Guild g where g.guildId = :id")
    void deleteById(@Param("id") UUID id);

    @Query("select g from Guild g where g.name like :name")
    Optional<Guild> findByName(@Param("name") String name);
}
