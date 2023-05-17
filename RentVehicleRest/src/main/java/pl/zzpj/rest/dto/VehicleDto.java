package pl.zzpj.rest.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDto {
    private UUID id;
    private String make;
    private String model;
    private long hourlyRate;
}
