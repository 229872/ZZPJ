package pl.zzpj.repository.core.domain.model.rentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.core.domain.model.userModel.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Rent {
    private UUID id;
    private Long version;
    private RentStatus status;
    private User user;
    private Vehicle vehicle;
    private BigDecimal price;
    private BigDecimal penalty;
    private LocalDateTime declaredStartDate;
    private LocalDateTime declaredEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;
    private LocalDateTime createdAt;

    @Builder(buildMethodName = "createBuild", builderMethodName = "createBuilder")
    public Rent(User user, Vehicle vehicle, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = null;
        this.version = 0L;
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
