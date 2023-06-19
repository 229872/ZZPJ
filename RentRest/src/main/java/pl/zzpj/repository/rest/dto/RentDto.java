package pl.zzpj.repository.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.rest.dto.VehicleDto;
import pl.zzpj.repository.rest.dto.output.UserOutputDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class RentDto {
    private UUID id;
    private Long version;
    private RentStatus status;
    private UserOutputDTO user;
    private VehicleDto vehicle;
    private BigDecimal price;
    private BigDecimal penalty;
    private LocalDateTime declaredStartDate;
    private LocalDateTime declaredEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private LocalDateTime createdAt;
}
