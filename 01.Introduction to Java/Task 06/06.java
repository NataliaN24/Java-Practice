public class leapYear {
    
    public static boolean isLeapYear(int year)
    {
        if(year < 1 || year >9999)
        {
            return false;
        }
        if(year % 4==0 )
        {
          if(year %100==0)
          {
            return year %400==0;
          }
          else
          {
            return true;
          }
        }
        else
        {
        return false;
        }
    }  
    public static void main(String[] args) {
        // Test cases
        System.out.println(isLeapYear(-1600)); // false
        System.out.println(isLeapYear(1600));  // true
        System.out.println(isLeapYear(2017));  // false
        System.out.println(isLeapYear(2000));  // true
    }
}
