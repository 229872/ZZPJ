package pl.zzpj.core.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@NoArgsConstructor
public abstract class AbstractDataModel implements Serializable {

    @Getter
    private UUID uuid;

    private LocalDateTime addDate;
}
