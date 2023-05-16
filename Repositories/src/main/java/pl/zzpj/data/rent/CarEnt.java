package pl.zzpj.data.rent;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import org.hibernate.annotations.Table;


@Entity
@Data
@Table(name = "Shop_Tire")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "ShopEquipmentEntId")
public class CarEnt extends VehicleEnt {


    private String fuelType;
    private int horsepower;
    private int seatCapacity;


}
