package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent;

import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.driver.AgeGroup;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.driver.Driver;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Bicycle;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Car;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.FuelType;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Създаваме услуга
        RentalService rentalService = new RentalService();

        // Създаваме шофьор
        Driver driver = new Driver(AgeGroup.EXPERIENCED);

        // Създаваме колело и кола
        Vehicle bike = new Bicycle("b1", "Trek", 20, 5); // pricePerDay=20, pricePerHour=5
        Vehicle car = new Car("c1", "Toyota", FuelType.DIESEL, 4, 1000, 150, 10);

        LocalDateTime rentStart = LocalDateTime.of(2025, 9, 20, 10, 0);

        try {
            rentalService.rentVehicle(driver, bike, rentStart);
            double bikePrice = rentalService.returnVehicle(bike, rentStart.plusHours(3));
            System.out.println("Bike rental price: " + bikePrice);

            rentalService.rentVehicle(driver, car, rentStart);
            double carPrice = rentalService.returnVehicle(car, rentStart.plusDays(2));
            System.out.println("Car rental price: " + carPrice);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
