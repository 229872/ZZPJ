package pl.zzpj.repository.data.rent;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.zzpj.core.domain.model.rentModel.RentStatus;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.repository.data.user.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "rent")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private RentStatus status;

    @ManyToOne(optional = false, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private Account user;

    @Column
    private String vehicle; //todo

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentEnt rentEnt)) return false;

        return id.equals(rentEnt.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
