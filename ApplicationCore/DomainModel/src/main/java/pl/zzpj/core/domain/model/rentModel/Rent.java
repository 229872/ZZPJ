package pl.zzpj.core.domain.model.rentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.zzpj.core.domain.model.userModel.Person;
import pl.zzpj.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Data
@AllArgsConstructor
public class Rent {
    private RentStatus status;
    private User user;
    private String vehicle; // todo
    private BigDecimal price;
    private BigDecimal penalty;
    private LocalDateTime declaredStartDate;
    private LocalDateTime declaredEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private LocalDateTime createdAt;

    @Builder
    public Rent(User user, String vehicle, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        this.status = RentStatus.CREATED;
        this.user = user;
        this.vehicle = vehicle;
        this.declaredStartDate = startDate;
        this.declaredEndDate = endDate;
        this.price = price;
        this.penalty = new BigDecimal(0);
        this.actualStartDate = null;
        this.actualEndDate = null;
        this.createdAt = LocalDateTime.now();
    }
}
