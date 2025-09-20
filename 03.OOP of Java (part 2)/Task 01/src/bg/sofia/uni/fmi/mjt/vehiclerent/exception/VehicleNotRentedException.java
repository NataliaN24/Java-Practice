package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception;

public class VehicleNotRentedException extends Exception {
     public VehicleNotRentedException()
    {
        super();//call the constructor of the parent class
    }
     public VehicleNotRentedException(String message)
    {
        super(message);
    }
    
}
