package pl.zzpj.repository.data.rent;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.data.AbstractEntity;
import pl.zzpj.repository.data.user.Account;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "rent")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RentEnt extends AbstractEntity {


    @Column
    @Enumerated(EnumType.STRING)
    private RentStatus status;

    @ManyToOne(optional = false, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private Account user;

    @ManyToOne(optional = false, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "vehicle_id", nullable = false, updatable = false)
    private VehicleEnt vehicle;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal penalty;

    @Column(name = "declared_start_date")
    @DateTimeFormat
    @NotNull
    private LocalDateTime declaredStartDate;

    @Column(name = "declared_end_date")
    @DateTimeFormat
    @NotNull
    private LocalDateTime declaredEndDate;

    @Column(name = "actual_start_date")
    @DateTimeFormat
    private LocalDateTime actualStartDate;

    @Column(name = "actual_end_date")
    @DateTimeFormat
    private LocalDateTime actualEndDate;

    @Column(name = "created_at")
    @DateTimeFormat
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
