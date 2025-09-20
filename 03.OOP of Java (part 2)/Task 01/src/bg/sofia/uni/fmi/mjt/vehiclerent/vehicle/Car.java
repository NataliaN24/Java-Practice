package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Car extends Vehicle {
private final FuelType fuelType;
private final int numberOfSeats;
private final double pricePerWeek;
private final double pricePerDay;
private final double pricePerHour;
private static final double SEAT_PRICE = 5.0;

    public Car(String id, String model, FuelType fuelType, int numberOfSeats, double pricePerWeek, double pricePerDay, double pricePerHour) {
        super(id, model);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.pricePerWeek = pricePerWeek;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }
    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException 
    {
         if (endOfRent.isBefore(startOfRent)) {
            throw new InvalidRentingPeriodException("End date is before start date");
        }
        Duration duration=Duration.between(startOfRent, endOfRent);
        long hours=duration.toHours();
        long days=duration.toDays();
        long weeks=days/7;
        if(hours<1){
            hours=1;
        }
        double price=0;
        if(weeks>0){
            price +=weeks*pricePerWeek;
            days-=weeks*7;
        }
        if(days>0){
            price +=days*pricePerDay;
            hours -=days*24;
        }
        if(hours>0){
            price +=hours*pricePerHour;
        }
        price +=fuelType.getDailyTax() * (duration.toDays()+1);
        price +=numberOfSeats *SEAT_PRICE;
        return price;

    }
    
}
