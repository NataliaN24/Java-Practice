package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;
import java.time.LocalDateTime;
import java.time.Duration;


import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.*;

public final class Bicycle extends Vehicle {
    private final double pricePerDay;
    private final double pricePerHour;

    public Bicycle(String id, String model,double pricePerDay, double pricePerHour) {
        super(id, model);
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }
    @Override
       public  double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException{
        if(endOfRent.isBefore(startOfRent)){
            throw new InvalidRentingPeriodException("end of date is before start date");
        }
        Duration duration=Duration.between(startOfRent, endOfRent);
        long hours=duration.toHours();
        long days=duration.toDays();
        if(days>=7){
            throw new InvalidRentingPeriodException("Bicycles cannot be rented for more than 1 week");
        }
        if(hours<1)
        {
            hours=1;
        }
        if(hours>=24){
            return days *pricePerDay +(hours %24)*pricePerHour;
        }
        else{
            return hours*pricePerHour;
        }
       }
}
