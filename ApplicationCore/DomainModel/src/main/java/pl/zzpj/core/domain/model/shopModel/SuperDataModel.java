package pl.zzpj.core.domain.model.shopModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperDataModel {

    private UUID id;

    private long version;
}