package pl.lodz.p.edu.zzpj.dto;

import java.util.UUID;

public record RandomDto(
        Long id, UUID uid, String color, String department,
        String material, String product_name, Double price, String price_string, String promoCode
) {
}
