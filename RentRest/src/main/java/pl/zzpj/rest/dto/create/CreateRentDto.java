package pl.zzpj.rest.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class CreateRentDto {
    private User user; //todo
    private String vehicle; //todo
    private BigDecimal price;
    private LocalDateTime declaredStartDate;
    private LocalDateTime declaredEndDate;
}
