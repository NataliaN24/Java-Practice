package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;

public enum FuelType {
    DIESEL(3),
    PETROL(3),
    HYBRID(1),
    ELECTRICITY(0),
    HYDROGEN(0);
    
    private final double dailyTax;
    FuelType(double dailyTax)
    {
        this.dailyTax=dailyTax;
    }
    public double getDailyTax(){
        return dailyTax;
    }
}
