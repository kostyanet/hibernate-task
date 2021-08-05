import dao.AutoDao;
import entity.Auto;
import entity.GearType;

import java.util.Arrays;

public class App {
    AutoDao dao = new AutoDao();

    public static void main(String[] args) {
        App app = new App();

        app.createAuto();
        app.updateAuto();
        app.getAuto();
        app.listAutos();
        app.deleteAutos();

        System.exit(0);
    }

    public void createAuto() {
        Auto auto1 = new Auto("Skoda", 18345, "2020-03-14", "2020-05-18", GearType.HYBRID, 55);
        Auto auto2 = new Auto("Lincoln", 62440, "2020-09-23", "2020-11-28", GearType.PETROL, 75);
        Auto auto3 = new Auto("Lexus", 50580, "2020-09-23", "2020-11-28", GearType.DIESEL, 60);
        dao.create(auto1);
        dao.create(auto2);
        dao.create(auto3);
    }

    public void updateAuto() {
        Auto auto1 = new Auto("Volvo", 59590, "2020-03-14", "2020-05-18", GearType.PETROL, 55);
        dao.create(auto1);
        auto1.setGearType(GearType.ELECTRIC);
        auto1.setFuelVolume(0);
        dao.update(auto1);
    }

    public void getAuto() {
        System.out.println(dao.getById(2));
        System.out.println(
                Arrays.toString(dao.getByTitle("Skoda").toArray())
        );
    }

    public void listAutos() {
        System.out.println(
                Arrays.toString(dao.listByPriceRange(50e3f, 60e3f).toArray())
        );
        System.out.println(
                Arrays.toString(dao.listAll().toArray())
        );
    }

    public void deleteAutos() {
        dao.deleteById(2);
    }

}
