package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.driver.Driver;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleAlreadyRentedException;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleNotRentedException;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Bicycle;
import OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Vehicle;

import java.time.LocalDateTime;

public class RentalService {
     /**
     * Simulates renting of the vehicle. Makes all required validations and then the provided driver "rents" the provided
     * vehicle with start time @startOfRent
     * @throws IllegalArgumentException if any of the passed arguments are null
     * @throws VehicleAlreadyRentedException in case the provided vehicle is already rented
     * @param driver the designated driver of the vehicle
     * @param vehicle the chosen vehicle to be rented
     * @param startOfRent the start time of the rental
     */

    public void rentVehicle(Driver driver, Vehicle vehicle, LocalDateTime startOfRent) throws VehicleAlreadyRentedException {
    if (driver == null || vehicle == null || startOfRent == null) {
            throw new IllegalArgumentException("Driver, vehicle, and startOfRent must not be null");
        }
        vehicle.rent(driver, startOfRent);
   
    }

    /**
     * This method simulates rental return - it includes validation of the arguments that throw the listed exceptions 
     * in case of errors. The method returns the expected total price for the rental - price for the vehicle plus
     * additional tax for the driver, if it is applicable 
     * @param vehicle the rented vehicle
     * @param endOfRent the end time of the rental
     * @return price for the rental
     * @throws IllegalArgumentException in case @endOfRent or @vehicle is null
     * @throws VehicleNotRentedException in case the vehicle is not rented at all
     * @throws InvalidRentingPeriodException in case the endOfRent is before the start of rental, or the vehicle 
     * does not allow the passed period for rental, e.g. Caravans must be rented for at least a day.
     */
    public double returnVehicle(Vehicle vehicle, LocalDateTime endOfRent) throws InvalidRentingPeriodException, VehicleNotRentedException {
       
         if (vehicle == null || endOfRent == null) {
            throw new IllegalArgumentException("Vehicle and endOfRent must not be null");
        }

        double rentalPrice = vehicle.calculateRentalPrice(vehicle.startRentTime, endOfRent);

        // add driver tax if vehicle is not Bicycle
        if (!(vehicle instanceof Bicycle)) {
            Driver driver = vehicle.getRentedBy();
            if (driver != null) {
                switch (driver.getGroup()) {
                    case JUNIOR :
                    rentalPrice += 10;
                    break;
                    case EXPERIENCED : 
                    rentalPrice += 0;
                    break;
                    case SENIOR: 
                    rentalPrice += 15;
                    break;
                    default:
                    break;
                }
            }
        }

        vehicle.returnBack(endOfRent);
        return rentalPrice;
    }
    }
