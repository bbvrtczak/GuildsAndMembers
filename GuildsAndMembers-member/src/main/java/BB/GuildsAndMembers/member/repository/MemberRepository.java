package BB.GuildsAndMembers.member.repository;

import BB.GuildsAndMembers.guild.entity.Guild;
import BB.GuildsAndMembers.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository for member entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    List<Member> findByGuild(Guild guild);
}
