package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception;

public class VehicleAlreadyRentedException extends Exception{
    public VehicleAlreadyRentedException()
    {
        super();//call the constructor of the parent class
    }
     public VehicleAlreadyRentedException(String message)
    {
        super(message);
    }
   

    
}
