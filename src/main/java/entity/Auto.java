package entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

/**
 * Auto entity must be featured by the following properties:
 * id, title, price, manufacture date, cell date, gear type, fuel volume
 */
@Entity
@Getter
@Setter
@Table(name = "auto")
public class Auto {
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
    private String manufactureDate;

    @Column(name = "cell_date")
    private String cellDate;

    @Column(name = "gearType")
    @Enumerated(EnumType.STRING)
    private GearType gearType;

    @Column(name = "fuel_volume")
    private int fuelVolume;

    public Auto() {}

    public Auto(String title, float price, String manufactureDate, String cellDate, GearType gearType, int fuelVolume) {
        this.title = title;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.cellDate = cellDate;
        this.gearType = gearType;
        this.fuelVolume = fuelVolume;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", cellDate='" + cellDate + '\'' +
                ", gearType=" + gearType +
                ", fuelVolume=" + fuelVolume +
                '}';
    }
}
