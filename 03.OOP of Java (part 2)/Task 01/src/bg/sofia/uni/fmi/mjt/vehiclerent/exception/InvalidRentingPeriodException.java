package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.exception;

public class InvalidRentingPeriodException extends Exception{
     public InvalidRentingPeriodException()
    {
        super();//call the constructor of the parent class
    }
     public InvalidRentingPeriodException(String message)
    {
        super(message);
    }
}
