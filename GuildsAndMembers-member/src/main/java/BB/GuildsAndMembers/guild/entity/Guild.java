package BB.GuildsAndMembers.guild.entity;

import BB.GuildsAndMembers.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "guilds")
public class Guild implements Serializable {

    /**
     * Unique id (primary key).
     */
    @Id
    private UUID id;

    /**
     * List of members. By default, list of members is not loaded from the database.
     */
    @OneToMany(mappedBy = "guild", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Member> members;
}
