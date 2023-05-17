package pl.zzpj.core.domain.model.shopModel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class SuperDataModel {

    private UUID id;

    private long version;

    public SuperDataModel(UUID id, long version) {
        this.id = id;
        this.version = version;
    }
}