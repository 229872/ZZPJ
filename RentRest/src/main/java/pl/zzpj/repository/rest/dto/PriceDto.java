package pl.zzpj.repository.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PriceDto {
    private BigDecimal price;
}
