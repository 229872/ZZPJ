package pl.zzpj.repository.rest.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
