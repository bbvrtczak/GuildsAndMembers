package BB.GuildsAndMembers.repository;

import BB.GuildsAndMembers.entity.Guild;
import BB.GuildsAndMembers.entity.Member;
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
    @Query("select m from Member m where m.guild = :guild")
    List<Member> findByGuild(@Param("guild") Guild guild);

    @Modifying
    @Query("delete from Member m where m.memberId = :id")
    void deleteById(@Param("id") UUID id);

    @Query("select m from Member m where m.memberId = :id")
    Optional<Member> findById(@Param("id") UUID id);

    @Query("select m from Member m")
    List<Member> findAll();
}




/*
private Map<UUID, Member> repository;

    public MemberRepository(){
        this.repository = new HashMap<>();
    }

    @Override
    public Member save(Member member) {
        return member;
    }

    @Override
    public Member findById(UUID id) {
        return null;
    }

    @Override
    public Member deleteById(UUID id) {
        return repository.remove(id);
    }

    findbyguild
    return repository.values()
                .stream()
                .filter(member -> member.getGuild().getName().equals(guildName))
                .collect(Collectors.toList());
*/
