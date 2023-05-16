package pl.zzpj.core.domain.model.rentModel;

import lombok.Getter;

@Getter
public enum RentStatus {
    CREATED,
    CANCELLED,
    ISSUED,
    NOT_ISSUED, // wymaga scheduled taska
    RETURNED_GOOD,
    RETURNED_DAMAGED,
    NOT_RETURNED
}
