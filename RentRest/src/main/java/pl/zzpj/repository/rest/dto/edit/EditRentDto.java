package pl.zzpj.repository.rest.dto.edit;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;

@Data
@AllArgsConstructor
public class EditRentDto {
    private RentStatus status;
}
