package pl.zzpj.repository.core.domain.model.rentModel;

import lombok.Getter;

@Getter
public enum RentStatus {
    CREATED,
    CANCELLED,
    ISSUED,
    NOT_ISSUED,
    RETURNED_GOOD,
    RETURNED_DAMAGED,
    NOT_RETURNED
}
