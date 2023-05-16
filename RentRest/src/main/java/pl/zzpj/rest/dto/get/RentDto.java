package pl.zzpj.rest.dto.get;

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
public class RentDto {
    private UUID id;
    private RentStatus status;
    private User user; //todo
    private String vehicle; //todo
    private BigDecimal price;
    private BigDecimal penalty;
    private LocalDateTime declaredStartDate;
    private LocalDateTime declaredEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private LocalDateTime createdAt;
}
