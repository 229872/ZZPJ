package pl.zzpj.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.ports.command.rent.RentCommandService;
import pl.zzpj.ports.query.rent.RentQueryService;
import pl.zzpj.rest.api.command.RentCommandRest;
import pl.zzpj.rest.api.query.RentQueryRest;

@Component
@AllArgsConstructor
public class RentRestAdapter implements RentQueryRest, RentCommandRest {
    private final RentCommandService commandService;
    private final RentQueryService queryService;
}
