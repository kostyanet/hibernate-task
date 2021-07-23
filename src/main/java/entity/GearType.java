package entity;

public enum GearType {

    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid");

    private final String value;

    GearType(String value) {
        this.value = value;
    }
}
