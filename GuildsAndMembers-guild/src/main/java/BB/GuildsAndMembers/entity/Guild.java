package BB.GuildsAndMembers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "guilds")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Guild implements Serializable, Comparable<Guild> {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guildId; // UUID as a PK

    private String name;
    private String region;
    private int creationYear;

    @Override
    public int compareTo(Guild other){
        return this.guildId.compareTo(other.getGuildId());
    }
}
