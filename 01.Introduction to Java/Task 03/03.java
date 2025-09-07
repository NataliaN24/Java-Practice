public class SpeedConverter {

    public static long toMilesPerHour (double kilometersPerHour )
    {
        if(kilometersPerHour <0)
        {
            return -1;
        }
        double milesPerHour=kilometersPerHour*0.621371;
        return Math.round(milesPerHour);
    }

    public static void printConversion(double kilometersPerHour)
    {
        double milesPerHour=toMilesPerHour(kilometersPerHour);
        if(milesPerHour ==-1)
        {
              System.out.println("Invalid Value");
        }
        else
        {
            System.out.println(kilometersPerHour + "km/h = "+ milesPerHour+ "mi/h");
        }
        
    }
  public static void main(String[] args) {
        printConversion(1.5);    // 1.5 km/h = 1 mi/h
        printConversion(10.25);  // 10.25 km/h = 6 mi/h
        printConversion(-5.6);   // Invalid Value
        printConversion(25.42);  // 25.42 km/h = 16 mi/h
        printConversion(75.114); // 75.114 km/h = 47 mi/h
    }
    
}
