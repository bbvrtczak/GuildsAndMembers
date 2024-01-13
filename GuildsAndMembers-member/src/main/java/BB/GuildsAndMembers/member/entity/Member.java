package BB.GuildsAndMembers.member.entity;

import BB.GuildsAndMembers.guild.entity.Guild;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable, Comparable<Member> {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID memberId; // UUID as a PK

    private String name;
    private String role;

    //@EqualsAndHashCode.Exclude
    //@ToString.Exclude
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // Bidirectional relationship
    @ManyToOne
    @JoinColumn(name = "guildId")
    private Guild guild;

    @Override
    public int compareTo(Member other){
        return this.memberId.compareTo(other.getMemberId());
    }
}