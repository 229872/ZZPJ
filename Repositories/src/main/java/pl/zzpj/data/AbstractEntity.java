package pl.zzpj.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {
    @Id
    @Column
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    @Getter
    private long version;

    protected AbstractEntity(UUID id, long version) {
        this.id = id;
        this.version = version;
    }
}
