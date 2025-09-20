package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Caravan extends Vehicle {
    private final FuelType fuelType;
    private final int numberOfSeats;
    private final int numberOfBeds;
    private final double pricePerWeek;
    private final double pricePerDay;
    private final double pricePerHour;

    private static final double SEAT_PRICE = 5.0;
    private static final double BED_PRICE = 10.0;

    public Caravan(String id, String model, FuelType fuelType, int numberOfSeats, int numberOfBeds,
                   double pricePerWeek, double pricePerDay, double pricePerHour) {
        super(id, model);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.numberOfBeds = numberOfBeds;
        this.pricePerWeek = pricePerWeek;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent)
            throws InvalidRentingPeriodException {

        if (endOfRent.isBefore(startOfRent)) {
            throw new InvalidRentingPeriodException("End date is before start date");
        }

        Duration duration = Duration.between(startOfRent, endOfRent);
        long hours = duration.toHours();
        long days = duration.toDays();
        long weeks = days / 7;

        if (hours < 24) {
            throw new InvalidRentingPeriodException("Caravan must be rented for at least 1 day");
        }

        double price = 0;

        if (weeks > 0) {
            price += weeks * pricePerWeek;
            days -= weeks * 7;
        }

        if (days > 0) {
            price += days * pricePerDay;
            hours -= days * 24;
        }

        if (hours > 0) {
            price += hours * pricePerHour;
        }

        // fuel такса, седалки, легла
        price += fuelType.getDailyTax() * (duration.toDays() + 1);
        price += numberOfSeats * SEAT_PRICE;
        price += numberOfBeds * BED_PRICE;

        return price;
    }
}