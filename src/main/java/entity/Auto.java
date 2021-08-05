package entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Auto entity must be featured by the following properties:
 * id, title, price, manufacture date, sell date, gear type, fuel volume
 */
@Entity
@Getter
@Setter
@Table(name = "auto")
public class Auto {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private float price;

    @NonNull
    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Column(name = "gear_type")
    @Enumerated(EnumType.STRING)
    private GearType gearType;

    @Column(name = "fuel_volume")
    private int fuelVolume;

    public Auto() {}

    public Auto(String title, float price, String manufactureDate, String sellDate, GearType gearType, int fuelVolume) {
        this.title = title;
        this.price = price;
        this.gearType = gearType;
        this.fuelVolume = fuelVolume;

        try {
            this.manufactureDate = LocalDate.parse(manufactureDate, formatter);
            this.sellDate = LocalDate.parse(sellDate, formatter);;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", sellDate='" + sellDate + '\'' +
                ", gearType=" + gearType +
                ", fuelVolume=" + fuelVolume +
                '}';
    }

}
