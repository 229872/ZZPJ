package pl.zzpj.repository.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class CreateRentDto {
    private UUID vehicleId;
    private UUID userId;
    private LocalDateTime declaredStart;
    private LocalDateTime declaredEnd;
}
