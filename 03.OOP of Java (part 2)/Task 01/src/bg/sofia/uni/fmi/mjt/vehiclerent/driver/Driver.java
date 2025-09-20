package OOP.src.bg.sofia.uni.fmi.mjt.vehiclerent.driver;

public class Driver {

    private final AgeGroup group;

    public Driver(AgeGroup group)
    {
        this.group=group;
    }
    public AgeGroup getGroup(){
        return group;
    }
    public double getTax()
    {
        switch(getGroup()){
            case JUNIOR :
                return 10;
        
            case EXPERIENCED :
            return 0;

            case SENIOR :
            return 15;
            
            default:
              throw new IllegalStateException("Unexpected AgeGroup: " + getGroup());
            
         }
    }
}
