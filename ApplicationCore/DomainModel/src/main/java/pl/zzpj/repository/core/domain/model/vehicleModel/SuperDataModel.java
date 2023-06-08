package pl.zzpj.repository.core.domain.model.vehicleModel;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class SuperDataModel {

    private UUID id;

    private long version;

    @Builder
    public SuperDataModel(UUID id, long version) {
        this.id = id;
        this.version = version;
    }
}