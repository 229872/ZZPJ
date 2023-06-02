package pl.zzpj.repository.data;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractEntity {
    @Id
    @Column
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    @Getter
    private Long version;

    protected AbstractEntity(UUID id, Long version) {
        this.id = id;
        this.version = version;
    }
}
