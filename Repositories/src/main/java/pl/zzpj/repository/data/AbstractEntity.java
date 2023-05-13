package pl.zzpj.repository.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@Data
public class AbstractEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
}
