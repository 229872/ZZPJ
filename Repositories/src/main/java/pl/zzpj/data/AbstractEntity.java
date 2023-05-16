package pl.zzpj.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractEntity {
    @Id
    @Column
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    @Getter
    private long version;
}
