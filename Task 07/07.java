public class DecimalComparator {
    
    public static boolean areEqualByThreeDecimalPlaces(double a, double b)
    {
        int num1 = (int)(a * 1000);
        int num2 = (int)(b * 1000);
        return num1 == num2;
    }
      public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // true
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));   // false
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));       // true
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));  // false
    }
}
