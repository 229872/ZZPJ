package pl.zzpj.repository.rest.dto;

import java.util.UUID;

public record RandomVehicleTireDto(
        Long id, UUID uid, String color, String department,
        String material, String product_name, Double price, String price_string, String promo_code
) {
}
